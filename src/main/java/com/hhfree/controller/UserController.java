package com.hhfree.controller;

import com.hhfree.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {


    private static List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(1, "张商", 11));
        userList.add(new User(2, "里斯", 12));
        userList.add(new User(3, "王武", 13));
    }

    /**
     * 进入用户列表
     * @apiGroup User
     * @api {get} /user/:id
     * @apiName apiName查看用户
     * @return
     */
    @RequestMapping("/list/mav")
    public ModelAndView userList() {
        ModelAndView mav=new ModelAndView();
        mav.addObject("listname", "用户列表");
        mav.addObject("userList", userList);
        mav.setViewName("user/list");
        return mav;
    }

    @RequestMapping("/list/string")
    public String userListString( Model model) {
        model.addAttribute("listname", "用户列表");
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView userEdit(@PathVariable("id") int id) {
        ModelAndView mav=new ModelAndView();
        mav.addObject("pagename", "用户信息修改");
        mav.addObject("user", new User(id, "张商", 12));
        mav.setViewName("user/edit");
        return mav;
    }

    @RequestMapping("/add")
    public String userAdd() {
        return "user/add";
    }
    @RequestMapping("/save")
    public ModelAndView userSave(String name, int age, HttpServletRequest request, HttpServletResponse response)throws Exception {
        String uname=request.getParameter("name");
        String uage=request.getParameter("age");
        System.out.println(name);
        System.out.println(age);

        ModelAndView mav=new ModelAndView();
        mav.setViewName("redirect:/user/list/mav");
        return mav;
    }

}
