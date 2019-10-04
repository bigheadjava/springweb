package com.cheer.bean;

public class Course {

	private int id;

	private ClazzBean clazz;

	private String name;

	private int times; // 课时

	private String description;

	public Course() {
		super();
	}

	public Course(ClazzBean clazz, String name, int times, String description) {
		super();
		this.clazz = clazz;
		this.name = name;
		this.times = times;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClazzBean getClazz() {
		return clazz;
	}

	public void setClazz(ClazzBean clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
