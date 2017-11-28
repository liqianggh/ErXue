package net.erxue.po;

import java.util.Date;

public class UserDisease {
	private Integer uid;
	private Integer diseaseCategoryId;
	private Date createTime;
	public UserDisease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDisease( Integer uid, Integer diseaseCategoryId,
			Date createTime) {
		super();
		this.uid = uid;
		this.diseaseCategoryId = diseaseCategoryId;
		this.createTime = createTime;
	}
 
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getDiseaseCategoryId() {
		return diseaseCategoryId;
	}
	public void setDiseaseCategoryId(Integer diseaseCategoryId) {
		this.diseaseCategoryId = diseaseCategoryId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserDisease [ uid=" + uid
				+ ", diseaseCategoryId=" + diseaseCategoryId + ", createTime="
				+ createTime + "]";
	}
}
