package com.cheer.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.bean.ClazzBean;
import com.cheer.bean.CodeBean;
import com.cheer.service.CodeService;
import com.cheer.service.ManageCourseService;
import com.cheer.validator.ClazzValidator;

@Controller
@RequestMapping("course")
public class ManageCourseController extends BaseController {
	
	private static Logger logger = Logger.getLogger(ManageCourseController.class);
	
	@Autowired
	CodeService codeService;
	@Autowired
	ManageCourseService manageCourseService;

	@RequestMapping("loadCreateClass")
	public ModelAndView loadCreateClass() {
		logger.info("....加载创建班级页面......");
		ModelAndView  mv = new ModelAndView("createClass");
		List<CodeBean> classKindList = codeService.getCodeByType("class_kind");
		List<CodeBean> classLocationList = codeService.getCodeByType("class_loc");
		CodeBean temp = new CodeBean();
		temp.setDescription("请选择");
		temp.setCodeId("");
		classLocationList.add(0, temp);
		mv.addObject("classKindList", classKindList);
		mv.addObject("classLocationList", classLocationList);
		mv.addObject("clazzBean", new ClazzBean());
		return mv;
	}
	
	/**
	 * 特别注意，@ModelAttribute后面的对象变量名称一定是对象对应的类名首字母小写
	 * @param clazzBean
	 * @param bindingResult
	 * @param redirectAttributes
	 * @param model
	 * @return
	 */
	@RequestMapping("createClass")
	public String createClass(@ModelAttribute("clazzBean") @Valid ClazzBean clazzBean, BindingResult bindingResult,RedirectAttributes redirectAttributes,  Model model) {
//		ClazzValidator cv = new ClazzValidator();
//		cv.validate(clazzBean, bindingResult);
		if(bindingResult.hasErrors()) {
			List<CodeBean> classKindList = codeService.getCodeByType("class_kind");
			List<CodeBean> classLocationList = codeService.getCodeByType("class_loc");
			CodeBean temp = new CodeBean();
			temp.setDescription("请选择");
			temp.setCodeId("");
			classLocationList.add(0, temp);
			model.addAttribute("classKindList", classKindList);
			model.addAttribute("classLocationList", classLocationList);
			model.addAttribute("clazzBean", clazzBean);
			ObjectError objError =  bindingResult.getGlobalError();
			if(objError != null) {
				model.addAttribute("succMsg", objError.getDefaultMessage());
			}
			return  "createClass";
		}
		
		manageCourseService.createClazz(clazzBean);
		redirectAttributes.addFlashAttribute("succMsg", "创建班级成功!");
		redirectAttributes.addFlashAttribute("clazzBean", clazzBean);
		return "redirect:loadCreateClass";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(new ClazzValidator());
//		binder.validate();
//	}
}


