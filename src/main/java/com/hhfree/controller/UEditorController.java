package com.hhfree.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/ueditor")
public class UEditorController {

	@RequestMapping("/demo")
	public String upload(Model model) {
		System.out.println("UEditorController");
		return "ueditor";
	}

	@RequestMapping("/config")
	public void config(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("configController");
		try {
			request.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "text/html");
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println(rootPath);
			System.out.println(rootPath);
			String exec = new ActionEnter(request, rootPath).exec();
			System.out.println(rootPath);
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}