package com.cheer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cheer.bean.ClazzBean;

@Component
public class ClazzMapper implements RowMapper<ClazzBean> {

	@Override
	public ClazzBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClazzBean clazz = new ClazzBean();
		clazz.setId(rs.getInt("id"));
		clazz.setLocation(rs.getString("location"));
		clazz.setDescription(rs.getString("description"));
		clazz.setPlanStartDate(rs.getDate("plan_start_date"));
		clazz.setPlanStartDate(rs.getDate("plan_end_date"));
		return clazz;
	}

}
