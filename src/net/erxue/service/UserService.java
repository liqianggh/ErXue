package net.erxue.service;

import java.util.List;

import net.erxue.common.ServerResponse;
import net.erxue.others.messageQQ.lib.SmsSingleSenderResult;
import net.erxue.po.User;
import net.erxue.po.UserCustom;
import net.erxue.po.UserDisease;
import net.erxue.po.UserJurisdiction;
import net.erxue.vo.UserDiseaseVo;

public interface UserService {
	

	public SmsSingleSenderResult sendMessage(String phone)throws Exception;


	public User login(User user)throws Exception;
	
	public boolean chechUsername(String username)throws Exception;
	
	public UserCustom findUserById(Integer uid)throws Exception;

	public List<UserDiseaseVo> findUserDisease(Integer uid)throws Exception;
	
	public boolean addUserDisease(UserDisease userDisease)throws Exception;
	
	public ServerResponse registUser(User user);
	
	public boolean isHaveAuthority(UserJurisdiction userJ) throws Exception;
	
	public boolean cutUserLevel(Integer uid)throws Exception;
	public boolean addUserLevel(Integer uid)throws Exception;
	public Integer getUserLevel(Integer uid)throws Exception;
	
	public boolean addUserJurisdiction(UserJurisdiction userJ)throws Exception;
	

}
