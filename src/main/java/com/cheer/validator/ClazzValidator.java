package com.cheer.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cheer.bean.ClazzBean;

public class ClazzValidator implements Validator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		boolean result = ClazzBean.class.isAssignableFrom(clazz);
		return result;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClazzBean clazz = (ClazzBean) target;
		if(StringUtils.isEmpty(clazz.getKind())) {
			errors.rejectValue("kind", "field.mandatory",null,"");
		}
		ValidationUtils.rejectIfEmpty(errors, "name", "field.mandatory");
	}
	
}
