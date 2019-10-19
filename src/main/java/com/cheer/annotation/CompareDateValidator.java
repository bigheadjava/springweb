package com.cheer.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.core.annotation.AnnotationConfigurationException;

public class CompareDateValidator implements ConstraintValidator<CompareDate, Object> {
	
	//默认值_false，用于接收自定义注解上的required属性值
	private boolean required = false;
	
	private String field1;
	
	private String field2;

	@Override
	public void initialize(CompareDate constraintAnnotation) {
		required = constraintAnnotation.required();
		field1 = constraintAnnotation.field1();
		field2 = constraintAnnotation.field2();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		if(required) {
			return validate(obj);
		}else {
			return true;
		}
	}
	
	private boolean validate(Object obj) {
		Class<?>  clazz = obj.getClass();
		try {
			Field f1 = clazz.getDeclaredField(field1);
			Field f2 = clazz.getDeclaredField(field2);
			if(!"class java.util.Date".equals(f1.getGenericType().toString())) {
				throw new AnnotationConfigurationException(field1 + ": not the type of java.util.Date.");
			}
			if(!"class java.util.Date".equals(f2.getGenericType().toString())) {
				throw new AnnotationConfigurationException(field2 + ": not the type of java.util.Date.");
			}
			Method m1 = obj.getClass().getMethod("get" + getMethodName(field1));
			Method m2 = obj.getClass().getMethod("get" + getMethodName(field2));
			Date d1 = (Date) m1.invoke(obj);
			Date d2 = (Date) m2.invoke(obj);
			if(d1 == null || d2 == null) {
				return true;
			}
			return d1.getTime() <= d2.getTime();
			
		} catch (NoSuchFieldException | SecurityException | AnnotationConfigurationException 
				| NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
	}

	private String getMethodName(String fieldName) {
		byte[] bytes = fieldName.getBytes();
		bytes[0] = (byte)((char)bytes[0] - 'a' + 'A');
		return new String(bytes);
	}
}
