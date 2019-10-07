package com.cheer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {
	
	@ModelAttribute
	public void isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String userName = (String) request.getSession().getAttribute("userName");
		if(StringUtils.isEmpty(userName)) {
			request.setAttribute("UnLoginError", "对不起，您还未进行登陆，请先登陆!");
			request.getRequestDispatcher("/logout").forward(request, response);
		}
	}
	
}
