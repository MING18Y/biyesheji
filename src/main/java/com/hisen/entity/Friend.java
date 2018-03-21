package com.hisen.entity;

public class Friend {
	
	private String friendId;
	private String friendName;
	private String friendHeadImg;
	private String friendSignature;
	private String friendEmail;
	
  @Override
  public String toString() {
    return "Friend{" +
        "friendId=" + friendId +
        ", friendName='" + friendName + '\'' +
        ", friendHeadImg=" + friendHeadImg +
        ", friendSignature='" + friendSignature + '\'' +
        ", friendEmail='" + friendEmail + '\'' +
        '}';
  }
	
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendHeadImg() {
		return friendHeadImg;
	}
	public void setFriendHeadImg(String friendHeadImg) {
		this.friendHeadImg = friendHeadImg;
	}
	public String getFriendSignature() {
		return friendSignature;
	}
	public void setFriendSignature(String friendSignature) {
		this.friendSignature = friendSignature;
	}
	public String getFriendEmail() {
		return friendEmail;
	}
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
	
	

}
