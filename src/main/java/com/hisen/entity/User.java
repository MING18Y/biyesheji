package com.hisen.entity;

public class User {
	private String userid;
	private String userpassword;
	private String usernickname;
	private String useremail;
	private String usersignature;
	private String userheadimg;
	
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsersignature() {
		return usersignature;
	}
	public void setUsersignature(String usersignature) {
		this.usersignature = usersignature;
	}
	public String getUserheadimg() {
		return userheadimg;
	}
	public void setUserheadimg(String userheadimg) {
		this.userheadimg = userheadimg;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}

	

}
