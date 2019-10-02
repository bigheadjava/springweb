package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeController extends BaseController{
	
	@ModelAttribute
	public void prepare1(@RequestParam int age, Model model) {
		model.addAttribute("age", age);
		model.addAttribute("msg1", "热烈庆祝");
		model.addAttribute("msg2", "周岁生日快乐! 祝愿祖国繁荣昌盛!");
		model.addAttribute("country", "中国");
	}
	
	@ModelAttribute("company")
	public String prepare2() {
		return "其然软件";
	}
	
	@RequestMapping(value="countryBirthday")
	public String loadCountryBirth(@ModelAttribute("country") String country) {
		return "countryBitrhday";
	}
}
