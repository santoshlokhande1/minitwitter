package com.sample.postgress.entity;

import javax.validation.constraints.Size;

public class Tweet {

    private String userName;
    
    @Size(max=140)
    private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
