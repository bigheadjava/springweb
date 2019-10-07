package com.cheer.bean;

import java.text.ParseException;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.cheer.annotation.CompareDate;
import com.cheer.util.DateUtil;

@CompareDate(field1 = "planStartDate", field2 = "planEndDate")
public class ClazzBean {

	private int id;

	@NotBlank(message = "{field.mandatory.kind}")
	@Length(min = 1, max = 20, message = "{max.length.kind}")
	private String kind; // 班级类型
	@NotBlank(message = "{field.mandatory.location}")
	@Length(min = 1, max = 20, message = "{max.length.kind}")
	private String location;
	@NotBlank(message = "{field.mandatory.name}")
	@Length(min = 1, max = 50, message = "{max.length.name}")
	private String name;
	@NotBlank(message = "{field.mandatory.description}")
	@Length(min = 1, max = 100, message = "{max.length.kind}")
	private String description;
	@Future(message = "{future.date.planStartDate}")
	@NotNull(message = "{field.mandatory.planStartDate}")
	private Date planStartDate;
	@Future(message = "{future.date.planEndDate}")
	@NotNull(message = "{field.mandatory.planEndDate}")
	private Date planEndDate;

	private String planStartDateAsStr;

	private String planEndDateAsStr;

	public ClazzBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClazzBean(String kind, String location, String name, String description) {
		super();
		this.kind = kind;
		this.location = location;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanStartDateAsStr() throws ParseException {
		if (planStartDate == null)
			return null;
		return DateUtil.dateFormat(planStartDate, DateUtil.DATE_PATTERN);
	}

	public void setPlanStartDateAsStr(Date planStartDate) throws ParseException {
		if (planStartDate != null) {
			this.planStartDateAsStr = DateUtil.dateFormat(planStartDate, DateUtil.DATE_PATTERN);
		}
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanEndDateAsStr() throws ParseException {
		if (planEndDate == null)
			return null;
		return DateUtil.dateFormat(planEndDate, DateUtil.DATE_PATTERN);
	}

	public void setPlanEndDateAsStr(Date planEndDate) throws ParseException {
		if (planEndDate != null) {
			this.planEndDateAsStr = DateUtil.dateFormat(planEndDate, DateUtil.DATE_PATTERN);
		}
	}

}
