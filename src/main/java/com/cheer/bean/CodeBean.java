package com.cheer.bean;

public class CodeBean {

	private int id;

	private String codeId;

	private String typeName;

	private String description;

	private String statusCd;

	private int seq;

	public CodeBean() {
		super();
	}

	public CodeBean(String codeId, String typeName, String description, String statusCd, int seq) {
		super();
		this.codeId = codeId;
		this.typeName = typeName;
		this.description = description;
		this.statusCd = statusCd;
		this.seq = seq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
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

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}
