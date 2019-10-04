package com.cheer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cheer.bean.Course;
import com.cheer.mapper.CourseMapper;

@Repository
public class CourseDAO extends BaseDAO {

	@Autowired
	CourseMapper courseMapper;

	public int insert(Course course) {
		String sql = "insert into i_course (id, name, class_id, times, description) values(?,?,?,?,?)";
		return getJdbcTemplate().update(sql, course.getId(), course.getName(), course.getClazz().getId(),
				course.getTimes(), course.getDescription());
	}

	public List<Course> queryCourse(Course course) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select id, name, class_id, times, description from i_course where 1=1 ");
		if (course != null && course.getId() != 0) {
			sb.append(" and id = ? ");
			paramList.add(course.getId());
		}
		if (course != null && !StringUtils.isEmpty(course.getName())) {
			sb.append(" and name = ? ");
			paramList.add(course.getName());
		}
		if (course != null && course.getClazz() != null && course.getClazz().getId() != 0) {
			sb.append(" and class_id = ? ");
			paramList.add(course.getClazz().getId());
		}
		if (course != null && course.getTimes() != 0) {
			sb.append(" and times = ? ");
			paramList.add(course.getTimes());
		}
		if (course != null && !StringUtils.isEmpty(course.getDescription())) {
			sb.append(" and description = ? ");
			paramList.add(course.getDescription());
		}
		return getJdbcTemplate().query(sb.toString(), paramList.toArray(), courseMapper);
	}
}
