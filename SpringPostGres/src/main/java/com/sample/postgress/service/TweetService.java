package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Tweet;

public interface TweetService {
    List<Tweet> findAll();

    void createTweet(Tweet tw);

    void updateTweet(Tweet tw);

	List<Tweet> findAllFolllowerTweet(String userName);

}
