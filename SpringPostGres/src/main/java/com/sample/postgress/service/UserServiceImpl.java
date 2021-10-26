package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.UserDao;
import com.sample.postgress.entity.Users;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    
	@Override
	public void insertUser(Users user) {
		userDao.insertUser(user);
	}

	@Override
	public void updateUser(Users user) {
		userDao.updateUser(user);
	}

	@Override
	public List<Users> findAll() {
		return userDao.findAll();
	}

}
