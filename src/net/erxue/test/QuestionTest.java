package net.erxue.test;

import java.util.List;

import net.erxue.mapper.QuestionMapperCustom;
import net.erxue.po.Answer;
import net.erxue.po.QuestionCustom;
import net.erxue.po.User;
import net.erxue.service.QuestionService;
import net.erxue.vo.QuestionAnswer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuestionTest {
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
	
		context =new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	@Test
	public void test() throws Exception {
		QuestionMapperCustom  questionMapper = context.getBean(QuestionMapperCustom.class);
//		User user = new User();
//		user.setUid(7);
//		List<QuestionCustom> list = questionMapper.findMyQuestion(1);
//		Long x = list.get(0).getCreatetime().getTime();
//		System.out.println(x);
		
//		Answer answer = new Answer();
//		answer.setQid(1);
//		answer.setContent("这个问题我没法回答！");
//		int x = questionMapper.addAnswer(answer);
//		System.out.println(x);
		
		List<QuestionAnswer>  qa = questionMapper.findMyAnsweredQuestion(1);
		System.out.println(qa);
	
	}
	@Test
	public void test2() throws Exception {
		QuestionService  service =  (QuestionService) context.getBean("questionService");
//		User user = new User();
//		user.setUid(7);
//		List<QuestionCustom> list = service.findMyQuestionNoAnswer(1);
//		
//		System.out.println(list);

		QuestionAnswer qa = service.findQuestionAnswer(1);
		System.out.println(qa);
	}

}
