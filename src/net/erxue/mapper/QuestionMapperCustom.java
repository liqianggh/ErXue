package net.erxue.mapper;

import java.util.List;

import net.erxue.po.Answer;
import net.erxue.po.Question;
import net.erxue.po.QuestionCustom;
import net.erxue.po.User;
import net.erxue.vo.QuestionAnswer;

public interface QuestionMapperCustom {
	public List<QuestionCustom> findMyQuestionNoAnswerd(Integer uid);

	public int addMyQuestion(Question question);
	
	public int addAnswer(Answer answer) throws Exception;
	
	public int updateQuestionToAnswered(Integer qid)throws Exception;
	
	public List<QuestionAnswer>  findMyAnsweredQuestion(Integer uid)throws Exception;

	public int deleteQuestion(Integer qid) throws Exception;

	public List<QuestionCustom> findAllQuestion() throws Exception;

	public int deleteAnswer(Integer aid) throws Exception;

	public QuestionAnswer findQuestionAnswerByQid(Integer qid) throws Exception;

}
