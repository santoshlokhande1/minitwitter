package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Users;

public interface UserService {
    List<Users> findAll();

    void insertUser(Users user);

    void updateUser(Users user);

}
