package com.sample.postgress.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Follower;
import com.sample.postgress.mapper.FollowerRowMapper;

@Repository
public class FollowerDaoImpl implements FollowerDao {

    public FollowerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

	@Override
	public void insertFollower(Follower fw) {
		final String sql = "insert into follower(UserName , FollowerUserName) values(:userName,:followerUserName)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", fw.getUserName())
                .addValue("followerUserName", fw.getFollowerUserName());
        template.update(sql, param, holder);
		
	}

	@Override
	public List<Follower> findAll(String userName) {
		String query="select * from follower where userName='"+userName+"'";
        return template.query(query, new FollowerRowMapper());
	}

}
