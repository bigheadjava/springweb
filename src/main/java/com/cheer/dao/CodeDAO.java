package com.cheer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cheer.bean.CodeBean;
import com.cheer.mapper.CodeMapper;

@Repository
public class CodeDAO extends BaseDAO {

	@Autowired
	CodeMapper codeMapper;

	public int insertCode(CodeBean code) {
		String sql = "insert into i_code (code_id, type_name, description, status_cd, seq) " + "values(?,?,?,?,?)";
		return getJdbcTemplate().update(sql, code.getCodeId(), code.getTypeName(), code.getDescription(),
				code.getStatusCd(), code.getSeq());
	}

	public CodeBean getCode(CodeBean code) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(
				"select id,code_id, type_name, description, status_cd, seq from i_code where 1=1 ");
		if (code != null && code.getId() != 0) {
			sb.append(" and id = ? ");
			paramList.add(code.getId());
		}
		if (code != null && !StringUtils.isEmpty(code.getTypeName()) && !StringUtils.isEmpty(code.getCodeId())) {
			sb.append(" and type_name = ? and code_id = ? ");
			paramList.add(code.getTypeName());
			paramList.add(code.getCodeId());
		}
		if (code != null && !StringUtils.isEmpty(code.getStatusCd())) {
			sb.append(" and status_cd = ? ");
			paramList.add(code.getStatusCd());
		}
		return getJdbcTemplate().queryForObject(sb.toString(), paramList.toArray(), codeMapper);
	}

	public List<CodeBean> getCodeList(CodeBean code) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer(
				"select id,code_id, type_name, description, status_cd, seq from i_code where 1=1 ");
		if (code != null && !StringUtils.isEmpty(code.getTypeName())) {
			sb.append(" and type_name = ? ");
			paramList.add(code.getTypeName());
		}
		if (code != null && !StringUtils.isEmpty(code.getCodeId())) {
			sb.append(" and code_id = ? ");
			paramList.add(code.getCodeId());
		}
		if (code != null && !StringUtils.isEmpty(code.getStatusCd())) {
			sb.append(" and status_cd = ? ");
			paramList.add(code.getStatusCd());
		}
		return getJdbcTemplate().query(sb.toString(), paramList.toArray(), codeMapper);
	}
}
