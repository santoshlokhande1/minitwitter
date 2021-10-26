package com.sample.postgress.entity;


public class Follower {

    private String userName;
    private String followerUserName;


	public String getFollowerUserName() {
		return followerUserName;
	}

	public void setFollowerUserName(String followerUserName) {
		this.followerUserName = followerUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
