package net.erxue.controller;

import javax.servlet.http.HttpSession;

import net.erxue.po.User;
import net.erxue.po.UserCustom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//测试专用
@Controller
public class SessionController {
	
	@RequestMapping(value="/getUser",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody User getUser(HttpSession session){

		User user =   (User) session.getAttribute("user");
		
		return user;
	}
	
	
	@RequestMapping(value="/setUser",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody boolean setUser(HttpSession session){

		 User user = new User();
		 user.setUsername("liqiang");
		 user.setPassword("liqiangpassword");
		 
		 session.setAttribute("user", user);
		
		return true;
	}
}
