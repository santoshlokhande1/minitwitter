package com.sample.postgress.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Users;
import com.sample.postgress.mapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

	@Override
	public void insertUser(Users user) {
		
		final String sql = "insert into users(UserName , UserEmail) values(:userName,:userEmail)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", user.getUserName())
                .addValue("userEmail", user.getUserEmail());
        template.update(sql, param, holder);
		
	}

	@Override
	public void updateUser(Users user) {
		final String sql = "update users set UserEmail=:userEmail where UserName=:userName";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", user.getUserName())
                .addValue("userEmail", user.getUserEmail());
        template.update(sql, param, holder);
		
	}

	@Override
	public List<Users> findAll() {
		return template.query("select UserName,UserEmail from users", new UserRowMapper());
	}

}
