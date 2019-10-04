package com.cheer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.bean.ClazzBean;
import com.cheer.bean.CodeBean;
import com.cheer.service.CodeService;
import com.cheer.service.ManageCourseService;

@Controller
@RequestMapping("course")
public class ManageCourseController extends BaseController {
	
	@Autowired
	CodeService codeService;
	@Autowired
	ManageCourseService manageCourseService;

	@RequestMapping("loadCreateClass")
	public ModelAndView loadCreateClass() {
		ModelAndView  mv = new ModelAndView("createClass");
		List<CodeBean> classKindList = codeService.getCodeByType("class_kind");
		List<CodeBean> classLocationList = codeService.getCodeByType("class_loc");
		mv.addObject("classKindList", classKindList);
		mv.addObject("classLocationList", classLocationList);
		mv.addObject("clazz", new ClazzBean());
		return mv;
	}
	
	@RequestMapping("createClass")
	public String createClass(ClazzBean clazz, RedirectAttributes redirectAttributes) {
		manageCourseService.createClazz(clazz);
		redirectAttributes.addFlashAttribute("succMsg", "创建班级成功!");
		redirectAttributes.addFlashAttribute("clazz", clazz);
		return "redirect:loadCreateClass";
	}
}


