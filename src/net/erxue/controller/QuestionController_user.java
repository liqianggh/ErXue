package net.erxue.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.erxue.po.Question;
import net.erxue.po.QuestionCustom;
import net.erxue.po.User;
import net.erxue.service.QuestionService;
import net.erxue.vo.QuestionAnswer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class QuestionController_user {
	@Autowired
	private QuestionService questionService;

	/**
	 * 提出问题 addQuestion.action
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(value = "addQuestion.action", method = { RequestMethod.POST })
	public @ResponseBody
	boolean poseMyQuestion(Question question, HttpServletResponse response,
			HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");

		User user = (User) session.getAttribute("user");
		if(user==null){
			return false;
		}else{
			question.setUid(user.getUid());
		}
		
		if (questionService.poseMyQuestion(question)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取我的未回复评论（已登录用户） getMyQuestionNoAnswer.action post/get
	 * 
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "getMyQuestionNoAnswer.action", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<QuestionCustom> getMyQuestionNoAnswer(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer uid = null;
		System.out.println(user + "user执行了");
		if (user != null) {
			uid = user.getUid();
		} else {
			return null;
		}
		if (uid == null) {
			return null;
		}
		List<QuestionCustom> list = null;
		try {
			list = questionService.findMyQuestionNoAnswer(uid);
		} catch (Exception e) {
			System.out.println("查询未回复咨询报错");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取我的已被回复评论（已登录用户） getMyQuestionAnswer.action post/get
	 * 
	 * @return
	 */
	@RequestMapping(value = "getMyQuestionAnswer.action", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	List<QuestionAnswer> getMyQuestionAnswer(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer uid = null;
		System.out.println("hahah" + user + "userssssss执行了");
		if (user != null) {
			uid = user.getUid();
		} else {
			uid = 1;
		}
		List<QuestionAnswer> qaList = null;
		try {
			qaList = questionService.findMyQuestionAnswered(uid);
		} catch (Exception e) {
			System.out.println("查询已回复咨询报错");
			e.printStackTrace();
		}

		return qaList;
	}

	/**
	 * deleteQuestion.action
	 * 删除提问
	 * @param qid
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "deleteQuestion.action", method = { RequestMethod.POST })
	public @ResponseBody
	boolean deleteQuestion(@Param("qid") Integer qid, HttpServletResponse response) {
		if(qid==null){
			return false;
		}
		try {
			return questionService.deleteQuestion(qid);
		} catch (Exception e) {
			System.out.println("删除报错了");
			e.printStackTrace();
			return false;
		}
	}

}
