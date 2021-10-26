package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Follower;

public interface FollowerService {
    List<Follower> findAll(String userName);

    void addFollower(Follower fw);


}
