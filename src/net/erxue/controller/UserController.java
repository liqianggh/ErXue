package net.erxue.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.erxue.common.ResponseCode;
import net.erxue.common.ServerResponse;
import net.erxue.others.messageQQ.lib.SmsSingleSenderResult;
import net.erxue.po.User;
import net.erxue.po.UserCustom;
import net.erxue.po.UserDisease;
import net.erxue.service.UserService;
import net.erxue.vo.UserDiseaseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

import cn.itcast.vcode.utils.VerifyCode;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
 
	/**
	 * 登陆
	 * login.action
	 * @param user（username,password）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody boolean login( User userParam,HttpServletResponse response,HttpSession session)throws Exception{
	System.out.println("login.aciton中的session对象"+session);
	System.out.println(userParam+"接收到的参数");
		if(userParam==null||userParam.getUsername()==null||userParam.getPassword()==null){
			return false;
		}
		User user = null;
		user = userService.login(userParam);
System.out.println(user+"登陆");
		if(user!=null){
			session.setAttribute("user", user);
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 注册 
	 * regist.action
	 * @param userCustom (username password)  
	 * @return boolean
	 * @throws Exception 
	 */
	@RequestMapping(value="/regist.action",method={RequestMethod.POST})
	public @ResponseBody ServerResponse regist( User user, String verifyCode,
			HttpSession session) throws Exception{
		if(user==null||user.getUsername()==null||user.getPassword()==null||verifyCode==null){
			return ServerResponse.createByErrorMessage("数据输入有误！");
		}
		if(!userService.chechUsername(user.getUsername())){
			ServerResponse.createByErrorMessage("用户名已经被注册!");	
		}
		String verifyCodeO =  (String) session.getAttribute("verifyCodeO");
		if(verifyCodeO==null||verifyCodeO.length()<1||(!verifyCodeO.equals(verifyCode))){
			return ServerResponse.createByErrorMessage("验证码错误！");
		}
		return userService.registUser(user);
	}
	
	
	/**
	 *发送短信验证码 
	 * sendMessageVerifyCode.action
	 * @param username(电话号码)
	 * @return int 返回0表示成功
	 */
	@RequestMapping(value="/sendMessageVerifyCode.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Integer sendMessageVerifyCode(String username,HttpSession session){
System.out.println("发送验证码的session"+session);
		if(username==null||username.length()<1){
			return -1;
		}
//		 SmsSingleSenderResult result=null;
//System.out.println("sendMessageVerifyCode.action中的session对象"+session);
		try {
//			result = userService.sendMessage(username);
//			session.setAttribute("verifyCode", result.getExt());
			session.setAttribute("verifyCodeO", "666666");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 return result.getResult();
		
		return 0;
	}
 
	/**
	 * 校验用户名是否已经注册
	 * checkUsername.action
	 */
	@RequestMapping(value="checkUsername.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ServerResponse  checkUsername(@RequestParam("username")String username){
		 boolean flag = false;
		try {
			if(username==null||username.length()<1){
				return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
			}
			flag = userService.chechUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			return ServerResponse.createBySuccess();
		}
		return ServerResponse.createByErrorMessage("用户名已经被注册!");
	}
	
}
