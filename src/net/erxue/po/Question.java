package net.erxue.po;

import java.util.Date;

public class Question {
	private Integer qid;
	private Integer uid;
	private String gender;
	private Integer age;
	private String content;
	private Date createtime;
	private boolean isAnswered;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(Integer qid, Integer uid, String gender, Integer age,
			String content, Date createtime, boolean isAnswered) {
		super();
		this.qid = qid;
		this.uid = uid;
		this.gender = gender;
		this.age = age;
		this.content = content;
		this.createtime = createtime;
		this.isAnswered = isAnswered;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public boolean isAnswered() {
		return isAnswered;
	}
	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", uid=" + uid + ", gender=" + gender
				+ ", age=" + age + ", content=" + content + ", createtime="
				+ createtime + ", isAnswered=" + isAnswered + "]";
	}
}
