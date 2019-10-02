package com.cheer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/course")
public class CourseController extends BaseController{
	
	@RequestMapping(value="/loadAddPage")
	public String loadScorePage(HttpServletRequest request, HttpServletResponse response) {
		
		return "score";
	}
}
