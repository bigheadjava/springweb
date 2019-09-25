package com.cheer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheer.bean.UserBean;
import com.cheer.mapper.UserBeanMapper;

@Repository
public class UserDAO extends BaseDAO {

	@Autowired
	private UserBeanMapper userBeanMapper;

	public int createUser(UserBean userBean) {
		String sql = "insert into i_user(user_name,user_password,name,gender,grade,tel_no,lottery_flag) values(?,?,?,?,?,?,?)";
		int count = getJdbcTemplate().update(sql, userBean.getUserName(), userBean.getUserPassword(),
				userBean.getName(), userBean.getGender(), userBean.getGrade(), userBean.getTelNo(),userBean.getLotteryFlag());
		return count;
	}

	public List<UserBean> queryUsers(UserBean userBean) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"select id, user_name,user_password,name,gender,grade,tel_no,lottery_flag from i_user where 1=1 ");
		if (userBean.getUserName() != null && !"".equals(userBean.getUserName().trim())) {
			sql.append(" and user_name = ? ");
			paramList.add(userBean.getUserName());
		}
		if (userBean.getUserPassword() != null && !"".equals(userBean.getUserPassword().trim())) {
			sql.append(" and user_password = ? ");
			paramList.add(userBean.getUserPassword());
		}
		if (userBean.getLotteryFlag() != null && !"".equals(userBean.getLotteryFlag().trim())) {
			sql.append(" and lottery_flag = ? ");
			paramList.add(userBean.getLotteryFlag());
		}

		return getJdbcTemplate().query(sql.toString(), paramList.toArray(), userBeanMapper);
	}

	public int updateUser(UserBean userBean) {
		String sql = "update i_user set lottery_flag = ? where id = ?";
		int count = getJdbcTemplate().update(sql, userBean.getLotteryFlag(), userBean.getId());
		return count;
	}

}
