package com.mumoo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mumoo.models.UserPojo;

@Repository
public class UserDao {

	private JdbcTemplate template;
	
    @Autowired
	public UserDao(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);

	}

    public int  getCountTotalUser(){
    	return getJdbcTemplate().queryForObject("Select count(*) from m_user",null,Integer.class);
    }
	public UserPojo findById(String id) throws EmptyResultDataAccessException {

		return getJdbcTemplate().queryForObject(
				"Select * from m_user where id = ?", new Object[] { id },
				new BeanPropertyRowMapper(UserPojo.class));

	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return template;
	}

	public List<UserPojo> findAll( int from, int to) {

		String sql = "Select * from m_user limit " + from + ","
				+ to;
		List<UserPojo> list = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(UserPojo.class));

		return list;
	}

	public UserPojo create(UserPojo user) throws DataAccessException {

		String sql = "INSERT INTO m_user (id,name,location,password,email,picture) VALUES (?, ?, ?,?, ?, ?)";

		getJdbcTemplate().update(sql, user.getId(), user.getName(),
				user.getLocation(), user.getPassword(), user.getEmail(),
				user.getPicture());

		return user;

	}

	public UserPojo update(UserPojo user) throws DataAccessException {

		String sql = "update m_user set name=?,location=?,password=?,email=?,picture=? where id=? ";

		getJdbcTemplate().update(sql, user.getName(), user.getLocation(),
				user.getPassword(), user.getEmail(), user.getPicture(),
				user.getId());

		return user;
	}

	public int deleteUser(String id) throws DataAccessException {
		String sql = "delete from  m_user  where id=? ";
		return getJdbcTemplate().update(sql, id);

	}
}
