package comm.example.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private int userAge;
	private int joiningYear;
	private int releaseYear;
	public User() {
		super();
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public int getuserAge() {
		return userAge;
	}
	public void setuserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getJoiningYear() {
		return joiningYear;
	}
	public void setJoiningYear(int joiningYear) {
		this.joiningYear = joiningYear;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAge=" + userAge + ", joiningYear="
				+ joiningYear + ", releaseYear=" + releaseYear + "]";
	}
	
	

}