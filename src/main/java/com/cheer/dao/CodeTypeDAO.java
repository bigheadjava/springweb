package com.cheer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cheer.bean.CodeTypeBean;
import com.cheer.mapper.CodeTypeMapper;

@Repository
public class CodeTypeDAO extends BaseDAO {

	@Autowired
	CodeTypeMapper codeTypeMapper;

	public int insertCodetype(CodeTypeBean codeType) {
		String sql = "insert into i_code_type (type_name,description) values(?,?)";
		return getJdbcTemplate().update(sql, codeType.getTypeName(), codeType.getDescription());
	}

//	public CodeTypeBean getCodeType(CodeTypeBean codeType) {
//		List<Object> paramList = new ArrayList<Object>();
//		StringBuffer sb = new StringBuffer("select id,type_name,description from i_code_type where 1=1 ");
//		if (codeType != null && codeType.getId() != 0) {
//			sb.append(" and id = ? ");
//			paramList.add(codeType.getId());
//
//		}
//		if (codeType != null && !StringUtils.isEmpty(codeType.getTypeName())) {
//			sb.append(" and type_name = ? ");
//			paramList.add(codeType.getTypeName());
//		}
//
//		CodeTypeBean dbBean;
//		try {
//			dbBean = getJdbcTemplate().queryForObject(sb.toString(), paramList.toArray(), codeTypeMapper);
//		} catch (Exception e) {
//			dbBean = null;
//			e.printStackTrace();
//		}
//		return dbBean;
//	}

	public List<CodeTypeBean> getCodeType(CodeTypeBean codeType) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer("select id,type_name,description from i_code_type where 1=1 ");
		if (codeType != null && codeType.getId() != 0) {
			sb.append(" and id = ? ");
			paramList.add(codeType.getId());

		}
		if (codeType != null && !StringUtils.isEmpty(codeType.getTypeName())) {
			sb.append(" and type_name = ? ");
			paramList.add(codeType.getTypeName());
		}

		return getJdbcTemplate().query(sb.toString(), paramList.toArray(), codeTypeMapper);
	}
	
	public int updateCodeType(CodeTypeBean codeType) {
		String sql = "update i_code_type set description = ? where id = ?";
		return getJdbcTemplate().update(sql, codeType.getDescription(),codeType.getId());
	}

}
