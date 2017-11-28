package net.erxue.po;

import java.util.Date;

public class Answer {
	private Integer aid;
	private Integer qid;
	private String content;
	private Date answerTime;
	private String time;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", qid=" + qid + ", content=" + content
				+ ", answerTime=" + answerTime + ", time=" + time + "]";
	}
	

}
