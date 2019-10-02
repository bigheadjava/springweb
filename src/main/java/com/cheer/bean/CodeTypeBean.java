package com.cheer.bean;

public class CodeTypeBean {

	private int id;

	private String typeName;

	private String description;

	public CodeTypeBean() {
		super();
	}

	public CodeTypeBean(String typeName, String description) {
		super();
		this.typeName = typeName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
