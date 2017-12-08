package net.erxue.mapper;

 
import java.util.List;

import net.erxue.po.User;
import net.erxue.po.UserCustom;
import net.erxue.po.UserDisease;
import net.erxue.po.UserJurisdiction;
import net.erxue.vo.UserDiseaseVo;



public interface UserMapperCustom {
	//添加用户
	public int addUser(User user)throws Exception;
	
	//删除用户
	public void deleteUserById(int uid)throws Exception;
	
	//查询用户根据uid
	public UserCustom findUserCustomById(Integer uid)throws Exception;
	
	//根据用户名和密码查询用户
	public UserCustom findUserByUsernamePassword(User user)throws Exception;
	
	//查询用户是否已经组测
	public User checkUsernameIsExists(String username)throws Exception;
	//查询所患疾病
	public List<UserDiseaseVo> findUserDisease(Integer uid)throws Exception;
	
	//添加用户所患疾病
	public int addUserDisease(UserDisease userDisease)throws Exception;
	
	
	//修改用户详细信息
	public void updaUserDetail(UserCustom userCustom)throws Exception;
	public void updateUser(UserCustom userCustom)throws Exception;
	
	
	
	//用户权限模块
	
	public int addUserJurisdiction(UserJurisdiction userJ)throws Exception;
	public UserJurisdiction findUserJurisdiction(UserJurisdiction userJ)throws Exception;
	
	
	public int findUserLevel(Integer uid)throws Exception;
	public int cutUserLevel(Integer uid) throws Exception;
	public int addUserLevel(Integer uid) throws Exception;
	
	
}