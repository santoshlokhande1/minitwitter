package com.sample.postgress.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Tweet;
import com.sample.postgress.mapper.TweetRowMapper;

@Repository
public class TweetDaoImpl implements TweetDao {

    public TweetDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

	@Override
	public List<Tweet> findAll() {
		return template.query("select UserName,Text from tweet", new TweetRowMapper());
	}

	@Override
	public void insertTweet(Tweet tw) {
		final String sql = "insert into tweet(UserName , Text) values(:userName,:text)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", tw.getUserName())
                .addValue("text", tw.getText());
        template.update(sql, param, holder);
		
	}

	@Override
	public void updateTweer(Tweet tw) {
		final String sql = "update tweet set Text=:text where UserName=:userName";
		
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", tw.getUserName())
                .addValue("text", tw.getText());
        template.update(sql, param, holder);
		
	}

	@Override
	public List<Tweet> findAllFolllowerTweet(String userName) {
	   	String query="select UserName,Text from tweet where userName in (select userName from follower where followerUserName='"+userName+"')";
        return template.query(query, new TweetRowMapper());
	}

}
