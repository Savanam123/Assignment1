package com.jocata.student.request;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class StudentRequest {
	
	private Integer stuId;

	private String stuName;

	private String stuLname;

	private String stuCourse;

	private String stuMobile;

	private String stuEmail;

	private Date stuEntryDate;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuLname() {
		return stuLname;
	}

	public void setStuLname(String stuLname) {
		this.stuLname = stuLname;
	}

	public String getStuCourse() {
		return stuCourse;
	}

	public void setStuCourse(String stuCourse) {
		this.stuCourse = stuCourse;
	}

	public String getStuMobile() {
		return stuMobile;
	}

	public void setStuMobile(String stuMobile) {
		this.stuMobile = stuMobile;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public Date getStuEntryDate() {
		return stuEntryDate;
	}

	public void setStuEntryDate(Date stuEntryDate) {
		this.stuEntryDate = stuEntryDate;
	}

}
