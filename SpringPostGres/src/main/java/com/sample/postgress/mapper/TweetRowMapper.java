package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tweet;

public class TweetRowMapper implements RowMapper<Tweet> {

    @Override
    public Tweet mapRow(ResultSet rs, int arg1) throws SQLException {
        Tweet tw = new Tweet();
        tw.setUserName(rs.getString("UserName"));
        tw.setText(rs.getString("Text"));

        return tw;
    }
}
