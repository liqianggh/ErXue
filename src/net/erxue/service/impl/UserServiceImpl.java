package net.erxue.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.erxue.mapper.UserMapperCustom;
import net.erxue.others.messageQQ.MessageUtils;
import net.erxue.others.messageQQ.lib.SmsSingleSenderResult;
import net.erxue.po.User;
import net.erxue.po.UserCustom;
import net.erxue.po.UserDisease;
import net.erxue.po.UserJurisdiction;
import net.erxue.service.UserService;
import net.erxue.vo.UserDiseaseVo;

import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UserServiceImpl implements UserService {

  @Autowired 
  private UserMapperCustom userMapperCustom;

	/**
	 * 发送验证码
	 */
	@Override
	public  SmsSingleSenderResult sendMessage(String phone) throws Exception {
		SmsSingleSenderResult result  = new MessageUtils().sendMessage(phone);
		System.out.println(result + "验证码发送成功");
		return result;
	}

	/**
	 * 注册用户
	 * @return true  if regist is success
	 */
	@Override
	public boolean registUser(User user) throws Exception {
		int x = userMapperCustom.addUser(user);
		if(x==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public UserCustom login(User user) throws Exception {
		UserCustom user2 = userMapperCustom.findUserByUsernamePassword(user);
		if(user2!=null){
			user2.setPassword("");
		}
		return user2;
	}

	// 校验用户是否已经注册
	@Override
	public boolean chechUsername(String username) throws Exception {
		User user = userMapperCustom.checkUsernameIsExists(username);
		if (user == null) {
			return true;
		}
		return false;
	}


	//查询用户疾病和添加用户疾病
	@Override
	public List<UserDiseaseVo> findUserDisease(Integer uid) throws Exception {
		List<UserDiseaseVo> list = userMapperCustom.findUserDisease(uid);
		Date time = null;
		String regex = "yyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		
		for(UserDiseaseVo ud:list){
			time = ud.getCreateTime();
		System.out.println(time+"哈哈哈");
			ud.setTime(sdf.format(time));
		}
		return list;
	}
	@Override
	public boolean addUserDisease(UserDisease userDisease) throws Exception {
		if(userMapperCustom.addUserDisease(userDisease)==1){
			return true;
		}
		return false;
	}

	@Override
	public UserCustom findUserById(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.findUserCustomById(uid);
	}

	@Override
	public boolean isHaveAuthority(UserJurisdiction userJ) throws Exception {
		UserJurisdiction user = userMapperCustom.findUserJurisdiction(userJ);
		int uid=userJ.getUid();
		if(user!=null){
			return true;
		}else{
			//如果用户没有添加当前疾病 那么就消耗一个level
			int level = userMapperCustom.findUserLevel(uid);
			if(level>=1){
				 int x = userMapperCustom.cutUserLevel(uid);//==1?true:false;
				 int y = userMapperCustom.addUserJurisdiction(userJ);
				 return x==1?true:false;
			}else{
				return false;
			}
		}
	}

	//减少用户level
	@Override
	public boolean cutUserLevel(Integer uid) throws Exception {
		int level = userMapperCustom.findUserLevel(uid);
		if(level>=1){
			 return userMapperCustom.cutUserLevel(uid)==1?true:false;
		}
		return false;
	}

	//增加用户level
	@Override
	public boolean addUserLevel(Integer uid) throws Exception {
		int x = userMapperCustom.addUserLevel(uid);
		if(x==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Integer getUserLevel(Integer uid) throws Exception {
		return userMapperCustom.findUserLevel(uid);
	}

	@Override
	public boolean addUserJurisdiction(UserJurisdiction userJ) throws Exception {
		UserJurisdiction user = userMapperCustom.findUserJurisdiction(userJ);
		if(user==null){
			return userMapperCustom.addUserJurisdiction(userJ)==1?true:false;
		}else{
			return false;
		}
	}

}
