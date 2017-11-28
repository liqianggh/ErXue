package net.erxue.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.erxue.mapper.QuestionMapperCustom;
import net.erxue.po.Answer;
import net.erxue.po.Question;
import net.erxue.po.QuestionCustom;
import net.erxue.po.User;
import net.erxue.service.QuestionService;
import net.erxue.vo.QuestionAnswer;

import org.springframework.beans.factory.annotation.Autowired;

public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionMapperCustom questionMapper;
	
	//添加问题
	@Override
	public boolean poseMyQuestion(Question question) {
		
		int x = questionMapper.addMyQuestion(question);
		if(x==1){
			return true;
		}
		return false;
	}

	//查询未回答的问题
	@Override
	public List<QuestionCustom> findMyQuestionNoAnswer(Integer uid){
		List<QuestionCustom> list = questionMapper.findMyQuestionNoAnswerd(uid);
		String regex = "yy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		Date time = null;
		for(QuestionCustom qc : list){
			time=qc.getCreatetime();
			qc.setTime(sdf.format(time));
		}
		return list;
	}
	
	//查询已经回答的 问题
	@Override
	public 	List<QuestionAnswer>  findMyQuestionAnswered(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		List<QuestionAnswer> qaList = questionMapper.findMyAnsweredQuestion(uid);
		String regex = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		for(QuestionAnswer qa:qaList){
			qa.setTime(sdf.format(qa.getCreatetime()));
			List<Answer> anList = qa.getAnswerList();
			for(Answer ans:anList){
				ans.setTime(sdf.format(ans.getAnswerTime()));
			}
		}
		return qaList;
	}
	
	
	
	@Override
	public boolean addAnswer(Answer answer) throws Exception {
		int x = questionMapper.addAnswer(answer);
		
		if(x<1){
			return false;
		}
		questionMapper.updateQuestionToAnswered(answer.getQid());
		return true;
	}

	
	@Override
	public boolean deleteQuestion(Integer qid) throws Exception {
		int x =questionMapper.deleteQuestion(qid);
		if(x==1){
			return true;
		}
		return false;
	}
	
	//查询所有问题
	@Override
	public List<QuestionCustom> findAllQuestion() throws Exception {
		List<QuestionCustom> questionList = questionMapper.findAllQuestion();
		if(!questionList.isEmpty()){
			String regex = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(regex);
			for(QuestionCustom question:questionList){
				question.setTime(sdf.format(question.getCreatetime()));
			}
		}
		return questionList;
	}

	//删除回答
	@Override
	public boolean deleteAnswer(Integer aid) throws Exception {
		int x = questionMapper.deleteAnswer(aid);
		if(x==1){
			return true;
		}
		return false;
	}

	//查询问题和答案
	@Override
	public QuestionAnswer findQuestionAnswer(Integer qid) throws Exception {
		QuestionAnswer qa = questionMapper.findQuestionAnswerByQid(qid);
		String regex = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		if(qa!=null){
		List<Answer> anList = qa.getAnswerList();
			for(Answer ans:anList){
				ans.setTime(sdf.format(ans.getAnswerTime()));
			}
		}
		return qa;
	}


	
}
