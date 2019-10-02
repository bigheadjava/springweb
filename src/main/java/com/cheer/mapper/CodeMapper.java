package com.cheer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cheer.bean.CodeBean;

@Component
public class CodeMapper implements RowMapper<CodeBean> {
	
	@Override
	public CodeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		CodeBean code = new CodeBean();
		code.setId(rs.getInt("id"));
		code.setCodeId(rs.getString("code_id"));
		code.setDescription(rs.getString("description"));
		code.setSeq(rs.getInt("seq"));
		code.setStatusCd(rs.getString("status_cd"));
		code.setTypeName(rs.getString("type_name"));
		return code;
	}

}
