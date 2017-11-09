package com.hhfree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping("/page")
	public String upload(Model model){
		List<String> fileList = new ArrayList<String>();
		model.addAttribute("fileList", fileList);
		return "upload";
	}

	@RequestMapping("/one")
	public String oneUpload(@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request){

		String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "uploadimg/";
//		文件名
		String[] filenames = imageFile.getOriginalFilename().split("\\.");
		String filegeshi = filenames[filenames.length -1];
		
//		时间
		String filename = new Date().getTime() +"."+ filegeshi;
//		Long filename = new Date().getTime() ;
		System.out.println(filename);
		
		File dir = new File(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		System.out.println("文件上传到: " + uploadUrl + filename);
		
		File targetFile = new File(uploadUrl + filename);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			imageFile.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/springmvc/uploadimg/" + filename;
	}
	
	@RequestMapping("/more")
	public String moreUpload(Model model,HttpServletRequest request){
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
		
		String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "uploadimg/";
		File dir = new File(uploadUrl);
		System.out.println(uploadUrl);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		List<String> fileList = new ArrayList<String>();
		
		for (MultipartFile file :  files.values()) {

			File targetFile = new File(uploadUrl + file.getOriginalFilename());
			if (!targetFile.exists()) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					file.transferTo(targetFile);
					fileList.add("http://localhost:8080/springmvc/uploadimg/" + file.getOriginalFilename());
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	
		model.addAttribute("fileList", fileList);
		request.setAttribute("files", fileList);
		
		return "upload";
	}
	
}