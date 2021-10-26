package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Follower;

public interface FollowerDao {

	List<Follower> findAll(String userName);
	
    void insertFollower(Follower fw);

}
