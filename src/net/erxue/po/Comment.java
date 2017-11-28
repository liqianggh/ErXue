package net.erxue.po;

import java.util.Date;


public class Comment extends BaseBean{
	
	private Integer cid;
	private Integer diseaseId;
	private Integer uid;
	private String content;
	private Date createTime;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", diseaseId=" + diseaseId + ", uid="
				+ uid + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}
	
	

}
