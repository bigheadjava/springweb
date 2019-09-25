package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheer.bean.UserBean;
import com.cheer.service.UserService;

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loadRegister")
	public String loadRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value="/register", method= {RequestMethod.POST})
	public String register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String telNo = request.getParameter("telNo");
		
		if(userService.checkUserExisted(userName)) {
			request.setAttribute("RegErrorMsg", "用户名已经存在，请尝试更换用户名!");
			return "register";
		}
		
		UserBean userBean = new UserBean(userName, userPassword, name, gender, Integer.valueOf(grade), telNo);
		userService.userRegister(userBean);
		userBean.setUserPassword(null);
		request.setAttribute("user", userBean);
		return "registerSuccess";
	}
	
	@RequestMapping(value="/loadLogin")
	public String loadLoginPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if(userService.checkLoginSuccess(userName, userPassword)) {
			request.getSession().setAttribute("userName", userName);
			return "homePage";
		}else {
			request.setAttribute("LoginErrorMsg", "用户名密码不正确，请重新登陆!");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		request.getSession().invalidate();
		return "index";
	}
	
	@RequestMapping(value="/loadHomePage")
	public String loadHomePage() {
		return "homePage";
	}
	
	@RequestMapping(value="/loadLotteryPage")
	public String loadLotteryPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		List<UserBean> userList = userService.queryUnluckyUsers();
		request.setAttribute("studentList", userList);
		return "lottery";
	}
	
	@RequestMapping(value="/lottery")
	public String lottery(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		List<UserBean> userList = userService.queryUnluckyUsers();
		if(userList == null || userList.size() == 0) {
			request.setAttribute("LotteryErrorMsg", "当前没有用户参加抽奖活动!");
			return "lottery";
		}
		int count = userList.size();
		int lotteryNum = (int)(Math.random()*count);
		UserBean luckyUser = userList.get(lotteryNum);
		request.setAttribute("luckyStudent", luckyUser);
		luckyUser.setLotteryFlag("Y");
		userService.updateLotteryStatus(luckyUser);
		return "lotteryResult";
	}
}
