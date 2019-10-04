package com.cheer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.bean.CodeBean;
import com.cheer.bean.CodeTypeBean;
import com.cheer.dao.CodeDAO;
import com.cheer.dao.CodeTypeDAO;

@Service
public class CodeService {

	@Autowired
	CodeTypeDAO codeTypeDAO;
	@Autowired
	CodeDAO codeDAO;
	
	public int insertCodeType(CodeTypeBean codeType) {
		return codeTypeDAO.insertCodetype(codeType);
	}
	
	public CodeTypeBean getCodeType(CodeTypeBean bean) {
		List<CodeTypeBean> resultList = codeTypeDAO.getCodeType(bean);
		if(resultList == null || resultList.size() == 0) {
			return null;
		}
		return resultList.get(0);
	}
	
	public int insertCode(CodeBean code) {
		return codeDAO.insertCode(code);
	}
	
	public int getCodeSeq(String codeType){
		CodeBean code = new CodeBean();
		code.setTypeName(codeType);
		List<CodeBean> list =  codeDAO.getCodeList(code);
		if(list == null || list.size() == 0) {
			return 1;
		}
		return list.size() + 1;
	}
	
	public CodeBean getCode(CodeBean code) {
		List<CodeBean> list =  codeDAO.getCodeList(code);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	public List<CodeBean> getCodeByType(String typeName){
		CodeBean code = new CodeBean();
		code.setTypeName(typeName);
		return codeDAO.getCodeList(code);
	}
	
	public List<CodeTypeBean> getAllCodeType(){
		return codeTypeDAO.getCodeType(null);
	}
	
	public int updateCodeTypeDesc(CodeTypeBean codeType) {
		return codeTypeDAO.updateCodeType(codeType);
	}
}
