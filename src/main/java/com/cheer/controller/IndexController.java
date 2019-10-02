package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.bean.UserBean;
import com.cheer.service.UserService;

@Controller
public class IndexController extends BaseController{
	@Autowired
	private UserService userService;
	
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
