package com.cheer.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ TYPE, METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = CompareDateValidator.class)
public @interface CompareDate {
	
	boolean required() default true; //允许为空的属性
	
	String message() default "开始时间不能大于结束时间"; //如果要从资源文件中获取错误消息，则用 "{key}的形式"
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
	
	String field1(); //代表第一个时间的字段名字
	String field2(); //代表第二个时间的字段名字
	
}
