package com.cheer.bean;

public class UserBean {

	private int id;

	private String userName;

	private String userPassword;

	private String name;

	private String gender;

	private int grade;

	private String telNo;

	private String lotteryFlag;

	public UserBean() {
	}

	public UserBean(String userName, String userPassword, String name, String gender, int grade, String telNo) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
		this.telNo = telNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getLotteryFlag() {
		return lotteryFlag;
	}

	public void setLotteryFlag(String lotteryFlag) {
		this.lotteryFlag = lotteryFlag;
	}

}
