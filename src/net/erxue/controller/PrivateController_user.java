package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.erxue.po.User;
import net.erxue.po.UserCustom;
import net.erxue.po.UserDisease;
import net.erxue.service.UserService;
import net.erxue.vo.UserDiseaseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class PrivateController_user {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 我的资料
	 * myInfo.action
	 * method:post
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/myInfo.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody UserCustom myInfo(Integer uid)throws Exception{
		  
		UserCustom userCustom = null;
		userCustom = userService.findUserById(uid);
		
		return userCustom;
	}
	
	
	/**
	 * 查询我的疾病
	 * /myDisease.action
	 * @throws Exception
	 */
	@RequestMapping(value="/myDisease.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody List<UserDiseaseVo> myDisease()throws Exception{
		//TODO
//		User user = new User();
//		user.setUid(7);
		int uid = 1;
		  List<UserDiseaseVo> list = userService.findUserDisease(uid);
		return list ;
	}
	/**
	 * 添加我的疾病
	 * post
	 * @param userDisease
	 * @return boolean
	 */
	@RequestMapping(value="/addMyDisease.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody boolean addMyDisease(UserDisease userDisease,HttpSession session)throws Exception{
		UserCustom user =(UserCustom) session.getAttribute("user"); 
		userDisease.setUid(user.getUid());
		//TODO
		if(userService.addUserDisease(userDisease)){
			return true;
		}
		return false;
	}
	
	
}
