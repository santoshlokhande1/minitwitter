package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Users;

public interface UserDao {

	List<Users> findAll();
	
    void insertUser(Users user);

    void updateUser(Users user);

}
