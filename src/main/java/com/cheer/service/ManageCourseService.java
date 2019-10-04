package com.cheer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.bean.ClazzBean;
import com.cheer.dao.ClazzDAO;

@Service
public class ManageCourseService {

	@Autowired
	ClazzDAO clazzDAO;
	
	public int createClazz(ClazzBean clazz) {
		return clazzDAO.insert(clazz);
	}
}
