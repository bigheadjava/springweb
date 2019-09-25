package com.cheer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.bean.UserBean;
import com.cheer.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void userRegister(UserBean userBean) {
		userBean.setLotteryFlag("N");
		userDAO.createUser(userBean);
	}
	
	public boolean checkUserExisted(String userName) {
		UserBean user = new UserBean();
		user.setUserName(userName);
		List<UserBean> userList = userDAO.queryUsers(user);
		if(userList != null && userList.size() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkLoginSuccess(String userName, String userPassword) {
		UserBean user = new UserBean();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		List<UserBean> userList = userDAO.queryUsers(user);
		if(userList != null && userList.size() > 0) {
			return true;
		}
		return false;
	}
	
	public List<UserBean> queryUnluckyUsers(){
		UserBean user = new UserBean();
		user.setLotteryFlag("N");
		return userDAO.queryUsers(user);
	}
	
	public int updateLotteryStatus(UserBean userBean) {
		return userDAO.updateUser(userBean);
	}
}
