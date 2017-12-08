package net.erxue.po;

public class CommentCustom extends Comment{
	private String username;
	private String diseaseName;

	public String getDiseaseName() {
		return diseaseName;
	}
	private String time;
 
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CommentCustom ["+super.toString()+"username=" + username + ", diseaseName="
				+ diseaseName + "]";
	}

 
	
}
