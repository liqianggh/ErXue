package net.erxue.test;

import java.util.List;

import net.erxue.mapper.UserMapperCustom;
import net.erxue.po.User;
import net.erxue.po.UserDisease;
import net.erxue.po.UserJurisdiction;
import net.erxue.service.UserService;
import net.erxue.service.impl.QuestionServiceImpl;
import net.erxue.vo.UserDiseaseVo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
	
		context =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	@Test
	public void test() throws Exception {
//		UserService userService = (UserService) context.getBean("userService");
		UserMapperCustom mapper = context.getBean(UserMapperCustom.class);
		
//		UserDisease userDisease = new UserDisease();
//		userDisease.setUid(7);
//		userDisease.setDiseaseId(1);
//		System.out.println(userService.addUserDisease(userDisease));
//		User user = new User();
//		user.setUid(7);
//		System.out.println(userService.findUserDisease(user));
		 User user2 = new User();
//		user2.setUserame("liqiang2");
//		user2.setPassword("123456");
//		UserCustom user3  = userService.login(user2);
//		user2=mapper.checkUsernameIsExists("helloworld");
		 
//		 User user = new User();
//		 user.setUsername("helloworld");
//		 user.setPassword("helloworld");
//		 user2=mapper.findUserByUsernamePassword(user);
		
//		 UserDisease ud = new UserDisease();
//		 ud.setUid(1);
//		 ud.setDiseaseCategoryId(2);
//		 int x = mapper.addUserDisease(ud);
		 List<UserDiseaseVo > list = mapper.findUserDisease(1);
		 
		 System.out.println(list);
//		System.out.println(user2.toString()+"这是用户");
		
	}
	
	
	@Test
	public void test2() throws Exception {
		UserMapperCustom mapper = context.getBean(UserMapperCustom.class);
 
		UserJurisdiction userJ = new UserJurisdiction();
		userJ.setUid(1);
		userJ.setDiseaseCategoryId(3);
		
//		int x = mapper.addUserJurisdiction(userJ);
//		System.out.println(userJ);
//		UserJurisdiction userResult = mapper.findUserJurisdiction(userJ);
//		int x = mapper.findUserLevel(1);
		int x = mapper.addUserLevel(1);
//		int x = mapper.cutUserLevel(1);
		System.out.println(x);
	}

}
