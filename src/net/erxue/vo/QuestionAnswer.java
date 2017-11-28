package net.erxue.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.erxue.po.Answer;

public class QuestionAnswer {
	private Integer qid;
	private String gender;
	private Integer age;
	private String question;
	private Date createtime;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private List<Answer> answerList = new ArrayList<Answer>();

	public QuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	@Override
	public String toString() {
		return "QuestionAnswer [qid=" + qid + ", gender=" + gender + ", age="
				+ age + ", question=" + question + ", createtime=" + createtime
				+ ", time=" + time + ", answerList=" + answerList + "]";
	}


}
