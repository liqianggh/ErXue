package net.erxue.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import net.erxue.po.UserDisease;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserDiseaseVo extends UserDisease {

	private String time;
	private String username;
	private String diseaseCategoryName;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDiseaseCategoryName() {
		return diseaseCategoryName;
	}
	public void setDiseaseCategoryName(String diseaseCategoryName) {
		this.diseaseCategoryName = diseaseCategoryName;
	}
	@Override
	public String toString() {
		return super.toString()+ "UserDiseaseVo [time=" + time + ", username=" + username
				+ ", diseaseCategoryName=" + diseaseCategoryName + "]";
	}
	 
}
