//package net.erxue.test;
//
//import java.util.List;
//
//import net.erxue.controller.UserController;
//import net.erxue.mapper.AcupointMapperCustom;
//import net.erxue.mapper.CommentMapper;
//import net.erxue.mapper.DiseaseMapperCustom;
//import net.erxue.mapper.UserMapperCustom;
//import net.erxue.po.Acupoint;
//import net.erxue.po.AcupointCustom;
//import net.erxue.po.Comment;
//import net.erxue.po.CommentCustom;
//import net.erxue.po.DiseaseAndAcupoint;
//import net.erxue.po.DiseaseCategory;
//import net.erxue.po.DiseaseCustom;
//import net.erxue.po.DiseaseSystem;
//import net.erxue.po.DiseaseSystemCustom;
//import net.erxue.po.Modules;
//import net.erxue.po.Page;
//import net.erxue.po.User;
//import net.erxue.po.UserCustom;
//import net.erxue.po.UserDetail;
//import net.erxue.service.AcupointService;
//import net.erxue.service.UserService;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class MyTest {
//	ApplicationContext context;
//	@Before
//	public void setUp() throws Exception {
//	
//		context =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//	
//	}
//	
//	@Test
//	public void tetUser() throws Exception{
//		UserService service = (UserService) context.getBean("userService");
//		User user = new User();
//		user.setUid(7);
//		UserCustom userCustom = service.findUserWithDetailById(user);
//		System.out.println(userCustom);
//	}
//	
//
//	@Test
//	public void testComments(){
//		CommentMapper commentMapper = context.getBean(CommentMapper.class);
//		
////		Comment comment = new Comment();
////		comment.setContent("五星好评！");
////		comment.setDiseaseId(1);
////		comment.setUid(7);
//////		System.out.println(commentMapper.addComment(comment)+"添加成功");
////		List<CommentCustom> list = commentMapper.findAllComments();
////		System.out.println(list);
////		System.out.println(commentMapper.deleteCommentById(3));
//		
//		User user = new User();
//		user.setUid(7);
//		List<CommentCustom> list = commentMapper.findMyComments(user);
//		System.out.println(list);
//		
//	}
//	
//	@Test
//	public void testComments2(){
////		CommentMapper commentMapper = context.getBean(CommentMapper.class);
//		AcupointService acupointService = (AcupointService) context.getBean("acupointService");
//	}
//	
//	
//	@Test
//	public void test() throws Exception {
//		 UserService userService = (UserService)
//		 context.getBean("userService");
//		// List<User> list = userService.findUser();
//		// System.out.println(list);
//		
//		UserMapperCustom userMapperCustom = context.getBean(UserMapperCustom.class);
//		User user = new User();
//		user.setLevel("vip");
//		user.setPassword("46666666");
//		user.setUsername("LiSi");
//		user.setPic("d:/hello.jpg");
//		
//		UserDetail userDetail = new UserDetail();
//		userDetail.setAge(21);
//		userDetail.setRealName("李四");
//		userDetail.setDescription("又生病了");
//		userDetail.setGender("男");
//		userDetail.setMobilePhone("110");
////		int udid  = userMapperCustom.addUserDetail(userDetail);
////		System.out.println(udid+"这是插入返回的主键");
//		
//		user.setUserDetail(userDetail);
//		
//		userService.addUser(user);
////		System.out.println(userService.addUserDetail(userDetail)+"这是啥");
////		userMapperCustom.deleteUserById(7);
////		UserCustom userCustom = userMapperCustom.findUserWithDetailById(7);		 
////		System.out.println(userCustom);
//	}
//	@Test
//	public void testUpdateSelect()throws Exception{
//		 UserMapperCustom userMapperCustom = context.getBean(UserMapperCustom.class);
//		 User user = new User();
//		 user.setUid(7);
//		 UserCustom userCustom=userMapperCustom.findUserWithDetailById(user);
////		  System.out.println(userCustom.getUserDetail().getUdid()+"测试");
////		  userCustom.getUserDetail().setDescription("为什么不行了呢");
////		 userMapperCustom.updaUserDetail(userCustom);
//		 System.out.println(userCustom);
//	}
//	//疾病系统
//	@Test
//	public void testDiseaseSystem()throws Exception{
//		DiseaseMapperCustom diseaseMapperCustom =   context.getBean(DiseaseMapperCustom.class);
//
//		DiseaseSystemCustom diseaseSystemCustom = new DiseaseSystemCustom();
//		diseaseSystemCustom.setSystemName("循环系统疾病");
////		diseaseMapperCustom.addDiseaseSystem(diseaseSystemCustom);
//		
//		List<DiseaseSystem> list=diseaseMapperCustom.findAllDiseaseSystems();		
//		System.out.println(list);
//	}
//	//疾病分类
//	@Test
//	public void testDiseaseCategory()throws Exception{
//		DiseaseMapperCustom diseaseMapperCustom =   context.getBean(DiseaseMapperCustom.class);
//
////		DiseaseCategoryCustom diseaseCategoryCustom = new DiseaseCategoryCustom();
////		diseaseCategoryCustom.setDiseaseCategoryName("落枕");
////		diseaseCategoryCustom.setDiseaseDescription("人们在工作或日常生活中，由于某种原因突然头颈扭闪，肌肉无准备地强烈收缩或被牵拉，导致颈肌纤维或韧带等组织发生撕裂；也有在乘坐高速行驶的汽车中突然急刹车而致颈椎快速前后摆动造成损伤；还有少数睡姿不当所致。");
////		diseaseCategoryCustom.setDiseaseSystemId(1);
////		diseaseMapperCustom.addDiseaseCategory(diseaseCategoryCustom);
//		
//////		List<DiseaseCategoryCustom> list = diseaseMapperCustom.findDiseaseCategoryBySystemId(1);
////		System.out.println(list);
//		
//		DiseaseCategory diseaseCategory= diseaseMapperCustom.findDiseaseCategoryById(1);
//		System.out.println(diseaseCategory);
//	}
//	//疾病 
//	@Test
//	public void testDisease ()throws Exception{
//		DiseaseMapperCustom diseaseMapperCustom =   context.getBean(DiseaseMapperCustom.class);
//		DiseaseCustom diseaseCustom = new DiseaseCustom();
////		diseaseCustom.setAttention("症所指的扭挫伤一般是指肌腱、韧带、肌肉等软组织的损伤。故在耳穴治疗前要明确诊断、排出骨折。人体背面软组织损伤取耳背病变阳性反应点。 ");
//		diseaseCustom.setDiseaseCategoryId(1);
//		diseaseCustom.setDiseaseName("痛甚");
//		diseaseMapperCustom.addDisease(diseaseCustom);
//		
//	}
//	
//	//部位
//	@Test
//	public void testModules ()throws Exception{
//		AcupointMapperCustom acupointMapperCustom =   context.getBean(AcupointMapperCustom.class);
////		
////		Modules modules = new Modules();
////		modules.setDescription("耳垂上部的隆起部分称为对耳屏，由软骨和皮肤构成。对耳屏相当于人体头部。对耳屏两侧各有一凹陷，内侧的凹陷称为屏间切迹，外侧的凹陷称为轮屏切迹。假设对耳屏的屏尖为A点，B点是对耳屏与屏间切迹的分界点，C点是对耳屏与轮屏切迹的分界点。B点与C点之间的弧线是对耳屏的软骨组织与耳垂的皮肉组织之间的分界线。由A点向弧线BC画一直线，将扇形ABC分成两等份。");
////		
////		modules.setModulesName("对耳屏");
////		acupointMapperCustom.addModules(modules);
////		Modules modules = acupointMapperCustom.findModulesById(1);
//		Acupoint acupoint = new Acupoint();
//		acupoint.setAcupointName("大");
//		List<Acupoint> list = acupointMapperCustom.findAcupointsByNameByPage(acupoint);
//		System.out.println(acupoint.getPage().getTotalNumber());
//		System.out.println(list.size());
//		System.out.println(list);
//		
//	}
//	//穴位
//	@Test
//	public void testAcupoint()throws Exception{
//		AcupointMapperCustom acupointMapperCustom =   context.getBean(AcupointMapperCustom.class);
//		
//		AcupointCustom acupointCustom = new AcupointCustom();
////		acupointCustom.setDescription("在上颚、下颚连线中点");
////		acupointCustom.setModulesId(1);
////		acupointCustom.setAcupointName("舌");
//		
//		List<Acupoint>  list = acupointMapperCustom.findAllAcupoints();
////		List<Modules> list2 = acupointMapperCustom.findAllModules();
//		System.out.println(list);
////		System.out.println(list2);
//
//		
////		acupointMapperCustom.addAcupoint(acupointCustom);
////		Modules modules = new Modules();
////		List<Modules> list  = acupointMapperCustom.findAllModulesByPage(modules);
////		System.out.println(modules.getPage().getTotalNumber());
////		System.out.println(list.size());
//			
//	}
//	
//	//添加疾病的穴位
//	@Test
//	public void testDiseaseAndAcupoint()throws Exception{
//		DiseaseMapperCustom diseaseMapperCustom =   context.getBean(DiseaseMapperCustom.class);
////		DiseaseCustom diseaseCustom = new DiseaseCustom();
////		diseaseCustom.setDiseaseId(1);
//		DiseaseCustom diseaseCustom  = diseaseMapperCustom.findDiseaseById(2);
//System.out.println(diseaseCustom.getDiseaseName());
//		DiseaseAndAcupoint diseaseAndAcupoint1 = new DiseaseAndAcupoint();
//		diseaseAndAcupoint1.setDiseaseId(2);
//		diseaseAndAcupoint1.setAcupointType("主穴");
//		diseaseAndAcupoint1.setAcupointId(4);
//
//		DiseaseAndAcupoint diseaseAndAcupoint2 = new DiseaseAndAcupoint();
//		diseaseAndAcupoint2.setDiseaseId(2);
//		diseaseAndAcupoint2.setAcupointType("配穴");
//		diseaseAndAcupoint2.setAcupointId(5);
//		
//		DiseaseAndAcupoint diseaseAndAcupoint3 = new DiseaseAndAcupoint();
//		diseaseAndAcupoint3.setDiseaseId(2);
//		diseaseAndAcupoint3.setAcupointType("主穴");
//		diseaseAndAcupoint3.setAcupointId(6);
//		
//		
//		List<DiseaseAndAcupoint> list = diseaseCustom.getDiseaseAndAcupointList();
//		list.add(diseaseAndAcupoint1);
//		list.add(diseaseAndAcupoint2);
//		list.add(diseaseAndAcupoint3);
//		
//		System.out.println(diseaseCustom.toString());
//		 diseaseMapperCustom.addDiseaseAndAcupointList(diseaseCustom);
//		
////		List<DiseaseCustom> list2  = diseaseMapperCustom.findAllDiseaseWithAcupoints();
////		System.out.println(list2);
//		
//	}
//	//查询穴位
//	/**
//	 * @throws Exception
//	 */
//	@Test
//	public void findAcupointsByCategoryIdTest()throws Exception{
//		AcupointMapperCustom acupointMapperCustom =   context.getBean(AcupointMapperCustom.class);
////		List<AcupointCustom> list = acupointMapperCustom.findAcupointsByModulesId(1);
////		List<AcupointCustom> list = acupointMapperCustom.findAllAcupoins();
////		List<Modules> list = acupointMapperCustom.findAllModules();
////		AcupointCustom list = acupointMapperCustom.findAcupointsById(1);
////		List<AcupointCustom> list = acupointMapperCustom.findAcupointsByModulesId(1);
////		Acupoint acupoint = acupointMapperCustom.findAcupointsById(1);
////		acupoint.setVideolocation("d:/develop/upload/hello.avi");
////		acupointMapperCustom.updateAcupoint(acupoint);
//		//List<Acupoint> list = acupointMapperCustom.findAllAcupoins();
//		Acupoint acupoint = new Acupoint();
//		acupoint.setAcupointName("大");
//		List<Acupoint> list = acupointMapperCustom.findAcupointsByNameByPage(acupoint);
//		System.out.println(list.size());
//		System.out.println(list);
//	}
//	
//	//根据疾病差穴位
//	@Test
//	public void findAcupointsByDiseaseIdTest()throws Exception{
//		DiseaseMapperCustom diseaseMapperCustom =   context.getBean(DiseaseMapperCustom.class);
//		DiseaseCustom diseaseCustom= diseaseMapperCustom.findAcupointsByDiseaseId(1);
////		System.out.println(diseaseCustom.getDiseaseName()+","+diseaseCustom.getAttention()+diseaseCustom);
//		for (AcupointCustom acc : diseaseCustom.getAcupointCustomList()) {
//			System.out.println(acc.getAcupointName()+","+acc.getAcupointType()+","+acc.getDescription()+","+acc.getModulesId()+"，视频地址："+acc.getVideolocation());
//		}
//
//	}
//	@Test
//	public void findUserName()throws Exception{
//		 UserMapperCustom userMapper = context.getBean(UserMapperCustom.class);
//		 User user2 = new User();
//		 user2.setUsername("hellowrold");
//		 user2.setPassword("123456");
//		 System.out.println(user2);
//		 UserCustom userCustom = userMapper.findUser(user2);
//		 System.out.println(userCustom);
//	}
// 
// 
// 
//}
