package net.erxue.po;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
 
public class UserCustom extends User {
	//用户等级
	private String level;
	//创建时间
	private Date registTime;
	 
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	@Override
	public String toString() {
		return super.toString()+ "UserCustom [level=" + level + ", registTime=" + registTime
				+ "]";
	}

}
