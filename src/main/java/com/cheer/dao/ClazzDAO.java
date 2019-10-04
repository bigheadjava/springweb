package com.cheer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cheer.bean.ClazzBean;
import com.cheer.mapper.ClazzMapper;

@Repository
public class ClazzDAO extends BaseDAO {

	@Autowired
	ClazzMapper clazzMapper;

	public int insert(ClazzBean clazz) {
		String sql = "insert into i_class (name, kind, location,description,plan_start_date,plan_end_date) values(?,?,?,?,?,?)";
		return getJdbcTemplate().update(sql, clazz.getName(), clazz.getKind(), clazz.getLocation(),
				clazz.getDescription(),clazz.getPlanStartDate(),clazz.getPlanEndDate());
	}
	
	public List<ClazzBean> queryClass(ClazzBean clazz){
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select id, name, kind, location, description from i_clazz where 1=1 ");
		if(clazz != null && clazz.getId() != 0) {
			sb.append(" and id = ? ");
			paramList.add(clazz.getId());
		}
		if(clazz != null && !StringUtils.isEmpty(clazz.getLocation())){
			sb.append(" and location = ? ");
			paramList.add(clazz.getLocation());
		}
		if(clazz != null && !StringUtils.isEmpty(clazz.getName())) {
			sb.append(" and name = ? ");
			paramList.add(clazz.getName());
		}
		if(clazz != null && !StringUtils.isEmpty(clazz.getDescription())) {
			sb.append(" and description = ? ");
			paramList.add(clazz.getDescription());
		}
		return getJdbcTemplate().query(sb.toString(), paramList.toArray(), clazzMapper);
	}
}
