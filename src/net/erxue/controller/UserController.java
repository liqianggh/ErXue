package net.erxue.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 */
	@RequestMapping(value="/regist.action",method={RequestMethod.POST})
	public @ResponseBody boolean regist(@RequestBody User user,
			HttpSession session,HttpServletResponse response) throws IOException{
 System.out.println(user+"接收到的参数");
 System.out.println("regist.actionz中的session对象"+session);
		if(user==null||user.getUsername()==null||user.getPassword()==null){
			return false;
		}
		
		Boolean verifyResult = (Boolean) session.getAttribute("verifyResult");
		if(verifyResult==null||verifyResult==false){
			return false;
		}
		//验证后移除
		session.removeAttribute("verifyResult");
		boolean result=false;
		try {
		 result= userService.registUser(user);
		} catch (Exception e) {
			System.out.println("注册报错！");
			e.printStackTrace();
		}
		return result;
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
			session.setAttribute("verifyCode", "666666");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		 return result.getResult();
		
		return 666666;
	}
	/**
	 * 校验验证码（短信和图片都可以）
	 * checkout.action
	 * @param verifyCode
	 * @return boolean
	 */
	@RequestMapping(value="checkout.action" ,method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody boolean checkout( String verifyCode,HttpSession session){
System.out.println("接收到的数据"+verifyCode);
System.out.println("检验证码的session"+session);
		//获取验证码
		String verifyCodeInSession = (String) session.getAttribute("verifyCode");
System.out.println("session中的验证吗"+verifyCodeInSession);
		//session.removeAttribute("verifyCode");
		if(verifyCode==null||verifyCode==""||verifyCode.length()<4){
			return false;
		}
		if(verifyCode.equalsIgnoreCase(verifyCodeInSession)){
			session.setAttribute("verifyResult", true);
			return true;
		}else{
			session.setAttribute("verifyResult", false);
			return false;
		}
	}
	
	/**
	 * 获取验证码图片
	 * getVerifyCode.action
	 */
	@RequestMapping(value="/getVerifyCode.action",method={RequestMethod.GET,RequestMethod.POST})
	public void getVerifyCode(HttpServletResponse response,HttpSession session){
		VerifyCode verifyCode  = new VerifyCode();
		//必须先生成图片在生成验证码
		BufferedImage image = verifyCode.getImage();
		String code = verifyCode.getText();
		//输出到页面
		try {
			 session.removeAttribute("verifyCode");
			session.setAttribute("verifyCode", code);
			VerifyCode.output(image, response.getOutputStream());
		} catch (IOException e) {
			System.out.println("验证码出错了！");
			e.printStackTrace();
		}
	}
 
	/**
	 * 校验用户名是否已经注册
	 * checkUsername.action
	 * @param username
	 * @return boolean（如果用户名可用返回true，返回false表示已经注册）
	 */
	@RequestMapping(value="checkUsername.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody boolean checkUsername(@RequestBody String username){
System.out.println(username+"接收到的username");
		Boolean flag=false;
		try {
			if(username==null||username.length()<1){
				return flag;
			}
			
			flag = userService.chechUsername(username);
		} catch (Exception e) {
			System.out.println("校验用户名出错");
			e.printStackTrace();
		}
		return flag;
	}
	
}
