package com.cheer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.bean.CodeBean;
import com.cheer.bean.CodeTypeBean;
import com.cheer.service.CodeService;

@Controller
@RequestMapping("/code")
public class CodeController extends BaseController{
	
	@Autowired
	CodeService codeService;

	@RequestMapping("/loadAddCodeType")
	public String loadAddCodeTypePage() {
		return "addCodeType";
	}
	
	@RequestMapping("/getCodeTypeIntroduction")
	public void getCodeTypeIntroduction(HttpServletRequest request, HttpServletResponse response, @RequestParam String cityNo) throws IOException {
		PrintWriter writer = response.getWriter();
		//writer.write("这是一个Ajax的GET请求...");
		if("0512".equals(cityNo)) {
			writer.write("这是苏州");
		}else if("010".equals(cityNo)) {
			writer.write("这是北京");
		}else if("000".equals(cityNo)) {
			String s = "{\"name\": \"Tom\",\"age\": 18,\"gender\":\"Man\"}";
			writer.write(s);
		}
		writer.close();
	}
	
	@RequestMapping("/addCodeType")
	public String addCodeType(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String codeTypeName = request.getParameter("codeTypeName");
		String desc = request.getParameter("codeTypeDesc");
		CodeTypeBean codeType = new CodeTypeBean(codeTypeName, desc);
		String msg;
		CodeTypeBean codeTypeBean = new CodeTypeBean();
		codeTypeBean.setTypeName(codeTypeName);
		if(codeService.getCodeType(codeTypeBean) != null) {
			msg = "该 Code Type 名字已经存在，请更换名字再尝试!";
			redirectAttributes.addFlashAttribute("codeTypeName", codeTypeName);
			redirectAttributes.addFlashAttribute("codeTypeDesc", desc);
		}else {
			codeService.insertCodeType(codeType);
			msg = "添加 Code Type 成功!";
		}
		redirectAttributes.addFlashAttribute("addErrorMsg", msg);
		return "redirect:loadAddCodeType";
	}
	
	@RequestMapping("/listCodeType")
	public String listCodeType(HttpServletRequest request, HttpServletResponse response) {
		List<CodeTypeBean> codeTypeList = codeService.getAllCodeType();
		request.setAttribute("codeTypeList", codeTypeList);
		return "showCodeType";
	}
	
	@RequestMapping("loadEditCodeTypePage/{id}")
	public String loadEditCodeTypePage(HttpServletRequest request, HttpServletResponse response,@PathVariable int id) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		CodeTypeBean codeType = new CodeTypeBean();
		codeType.setId(id);
		CodeTypeBean dbBean = codeService.getCodeType(codeType);
		request.setAttribute("codeType", dbBean);
		return "editCodeType";
	}
	
	@RequestMapping("editCodeType")
	public String editCodeType(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		String idAsStr = request.getParameter("codeTypeId");
		String codeTypeDesc = request.getParameter("codeTypeDesc");
		CodeTypeBean codeType = new CodeTypeBean();
		codeType.setId(Integer.valueOf(idAsStr));
		codeType.setDescription(codeTypeDesc);
		codeService.updateCodeTypeDesc(codeType);
		redirectAttributes.addFlashAttribute("succMsg", "更新 Code Type成功!");
		return "redirect:loadEditCodeTypePage/"+Integer.valueOf(idAsStr); 
	}
	
	@RequestMapping(value="loadAddCodePage")
	public ModelAndView loadAddCodePage(HttpServletRequest request, HttpServletResponse response,Model model) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		List<CodeTypeBean>  allCodeTypeList = codeService.getAllCodeType();
		
		ModelAndView mv = new ModelAndView("addCode");
		mv.addObject("allCodeTypeList", allCodeTypeList);
		mv.addObject("code", new CodeBean());
		return mv;
	}
	
	@RequestMapping("addCode")
	public String addCode(CodeBean code, RedirectAttributes redirectAttributes) {
		CodeBean dbCode = codeService.getCode(code);
		String succMsg;
		if(dbCode != null) {
			succMsg = "Code ID已经存在，请更换 Code ID!";
		}else {
			succMsg = "添加 Code 成功!";
		}
		int codeSeq = codeService.getCodeSeq(code.getTypeName());
		code.setSeq(codeSeq);
		code.setStatusCd("A");
		codeService.insertCode(code);
		redirectAttributes.addFlashAttribute("succMsg", succMsg);
		redirectAttributes.addFlashAttribute("code",code);
		return "redirect:loadAddCodePage";		
	}
}
