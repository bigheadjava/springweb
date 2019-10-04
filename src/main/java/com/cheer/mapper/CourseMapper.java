package com.cheer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cheer.bean.ClazzBean;
import com.cheer.bean.Course;
import com.cheer.dao.ClazzDAO;


@Component
public class CourseMapper implements RowMapper<Course> {
	
	@Autowired
	ClazzDAO clazzDAO;

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt("id"));
		course.setName(rs.getString("name"));
		course.setTimes(rs.getInt("times"));
		course.setDescription(rs.getString("description"));
		
		int classId = rs.getInt("class_id");
		ClazzBean clazz = new ClazzBean();
		clazz.setId(classId);
		clazz = clazzDAO.queryClass(clazz).get(0);
		course.setClazz(clazz);
		return course;
	}

}
