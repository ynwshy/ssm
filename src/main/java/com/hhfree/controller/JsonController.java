package com.hhfree.controller;

import com.hhfree.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class JsonController {

	@ResponseBody
	@RequestMapping("/list")
	private List<User> list() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(1, "张商", 11));
		userList.add(new User(2, "里斯", 12));
		userList.add(new User(3, "王武", 13));
		return userList;
	}

	@ResponseBody
	@RequestMapping("/obj")
	public Object obj() {
		return new User(3, "王武", 13);
	}

	@ResponseBody
	@RequestMapping("/listString")
	public void listString(HttpServletResponse res) {
		res.setContentType("");
		try {
			res.getWriter().write("{'asd':123}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/jsons",method = RequestMethod.POST)
	public @ResponseBody void testData(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		String jsonStr = "[{'id':1,'name':'张商','age':11},{'id':2,'name':'里斯','age':12},{'id':3,'name':'王武','age':13}]";
		System.out.println("jsonStr:" + jsonStr);
		PrintWriter pw = null;
		pw = response.getWriter();
		pw.print(jsonStr);
		pw.flush();
		pw.close();
	}

}
