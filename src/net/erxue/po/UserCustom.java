package net.erxue.po;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
 
public class UserCustom extends User {
	//用户等级
	private Integer level;
	//创建时间
	private Date registTime;

	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return super.toString()+"UserCustom [level=" + level + ", registTime=" + registTime
				+ "]";
	}


}
