package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Users;

public class UserRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int arg1) throws SQLException {
        Users user = new Users();
        user.setUserName(rs.getString("UserName"));
        user.setUserEmail(rs.getString("UserEmail"));

        return user;
    }
}
