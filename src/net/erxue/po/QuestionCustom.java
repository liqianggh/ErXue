package net.erxue.po;

public class QuestionCustom extends Question {
	private String username;
	private String time;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return super.toString() + "QuestionCustom [username=" + username + "time"+time+"]";
	}

}
