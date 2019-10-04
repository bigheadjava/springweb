package com.cheer.bean;

import java.util.Date;

public class ClazzBean {

	private int id;

	private String kind; // 班级类型

	private String location;

	private String name;

	private String description;
	
	private Date planStartDate;
	
	private Date planEndDate;

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

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	
}
