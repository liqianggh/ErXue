package net.erxue.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.erxue.po.Answer;
import net.erxue.po.Question;
import net.erxue.po.QuestionCustom;
import net.erxue.service.QuestionService;
import net.erxue.vo.QuestionAnswer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/admin")
public class QuestionController_admin {

	@Autowired
	private QuestionService questionService;
	

	/**
	 * 回答问题
	 * addAnswer.action
	 * @param answer(qid,content)
	 * @return
	 */
	@RequestMapping(value="addAnswer.action",method={RequestMethod.POST})
	public@ResponseBody boolean poseMyQuestion(Answer answer){
		
		if(answer==null){
			return false;
		}
		try {
			if(	questionService.addAnswer(answer)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.out.println("添加回答报错了！");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询所有问题
	 * findAllQuestion.action
	 * @return
	 */
	@RequestMapping(value="findAllQuestion.action" ,method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<QuestionCustom> findAllQuestion(){
		List<QuestionCustom> questionList=null;
		try {
			 questionList= questionService.findAllQuestion();
		} catch (Exception e) {
			System.out.println("查询所有问题报错了");
			e.printStackTrace();
			return null;
			
		}
		
		return questionList;
	}
	/**
	 * 问题的回答
	 * findAnswerOfQuestion.action
	 * @param qid
	 * @return
	 */
	@RequestMapping(value="findAnswerOfQuestion.action",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody QuestionAnswer findAllAnswer(Integer qid){
		QuestionAnswer qa = null;
		try {
			 qa= questionService.findQuestionAnswer(qid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qa;
	}
	
	/**
	 * 删除回答
	 * /deleteAnswer.action
	 * @param aid
	 * @return
	 */
	@RequestMapping(value="deleteAnswer.action" ,method={RequestMethod.GET,RequestMethod.POST})
	public  @ResponseBody boolean deleteAnswer(Integer aid){
		if(aid==null){
			return false;
		}
		try {
			return  questionService.deleteAnswer(aid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 删除问题
	 * deleteQuestion.action
	 * @param qid
	 * @return
	 */
	@RequestMapping(value ="deleteQuestion.action", method = { RequestMethod.POST })
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
