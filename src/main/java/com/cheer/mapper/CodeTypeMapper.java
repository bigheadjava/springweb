package com.cheer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cheer.bean.CodeTypeBean;

@Component
public class CodeTypeMapper implements RowMapper<CodeTypeBean> {

	@Override
	public CodeTypeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		CodeTypeBean codeTypeBean = new CodeTypeBean();
		codeTypeBean.setId(rs.getInt("id"));
		codeTypeBean.setTypeName(rs.getString("type_name"));
		codeTypeBean.setDescription(rs.getString("description"));
		return codeTypeBean;
	}

}
