package com.cheer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cheer.bean.UserBean;

@Component
public class UserBeanMapper implements RowMapper<UserBean>{

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean user = new UserBean();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("user_name"));
		user.setUserPassword(rs.getString("user_password"));
		user.setName(rs.getString("name"));
		user.setLotteryFlag(rs.getString("lottery_flag"));
		user.setGender(rs.getString("gender"));
		user.setGrade(rs.getInt("grade"));
		return user;
	}

}
