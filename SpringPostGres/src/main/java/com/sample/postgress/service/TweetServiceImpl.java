package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.TweetDao;
import com.sample.postgress.dao.UserDao;
import com.sample.postgress.entity.Tweet;
import com.sample.postgress.entity.Users;

@Component
public class TweetServiceImpl implements TweetService {
    @Resource
    TweetDao twDao;
    
	@Override
	public void createTweet(Tweet tw) {
		twDao.insertTweet(tw);
		
	}

	@Override
	public void updateTweet(Tweet tw) {
		twDao.updateTweer(tw);
	}

	@Override
	public List<Tweet> findAll() {
		return twDao.findAll();
	}
	
	@Override
	public List<Tweet> findAllFolllowerTweet(String userName) {
		return twDao.findAllFolllowerTweet(userName);
	}

}
