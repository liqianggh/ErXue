package net.erxue.service;

import java.util.List;

import net.erxue.po.Answer;
import net.erxue.po.Question;
import net.erxue.po.QuestionCustom;
import net.erxue.vo.QuestionAnswer;


public interface QuestionService {
	
	public List<QuestionCustom> findMyQuestionNoAnswer(Integer uid)throws Exception;

	public boolean poseMyQuestion(Question question);
	public boolean addAnswer(Answer answer)throws Exception;
	
	public 	List<QuestionAnswer>  findMyQuestionAnswered(Integer uid)throws Exception;

	public boolean deleteQuestion(Integer qid)throws Exception;

	public List<QuestionCustom> findAllQuestion()throws Exception;

	public boolean deleteAnswer(Integer aid)throws Exception;

	public QuestionAnswer findQuestionAnswer(Integer qid)throws Exception;

	

}
