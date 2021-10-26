package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Follower;
import com.sample.postgress.entity.Tweet;

public class FollowerRowMapper implements RowMapper<Follower> {

    @Override
    public Follower mapRow(ResultSet rs, int arg1) throws SQLException {
        Follower fw = new Follower();
        fw.setUserName(rs.getString("UserName"));
        fw.setFollowerUserName(rs.getString("FollowerUserName"));

        return fw;
    }
}
