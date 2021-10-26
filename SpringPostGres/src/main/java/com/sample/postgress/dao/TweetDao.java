package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Tweet;

public interface TweetDao {

	List<Tweet> findAll();
	
    void insertTweet(Tweet tw);

    void updateTweer(Tweet tw);
    
    List<Tweet> findAllFolllowerTweet(String userName);
}
