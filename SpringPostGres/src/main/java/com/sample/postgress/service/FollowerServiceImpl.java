package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.FollowerDao;
import com.sample.postgress.entity.Follower;

@Component
public class FollowerServiceImpl implements FollowerService {
    @Resource
    FollowerDao fwDao;

	@Override
	public List<Follower> findAll(String userName) {
		return fwDao.findAll(userName);
	}

	@Override
	public void addFollower(Follower fw) {
		fwDao.insertFollower(fw);
		
	}

}
