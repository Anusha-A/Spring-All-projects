package com.example.demo.model;



public class Users {
	
	private Long userId;

	   private String name;

	   private String practiceArea;

	   private String designation;

	   private String companyInfo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPracticeArea() {
		return practiceArea;
	}

	public void setPracticeArea(String practiceArea) {
		this.practiceArea = practiceArea;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", practiceArea=" + practiceArea + ", designation="
				+ designation + ", companyInfo=" + companyInfo + "]";
	}

	  
	

}