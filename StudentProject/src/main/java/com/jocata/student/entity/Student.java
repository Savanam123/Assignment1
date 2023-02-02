package com.jocata.student.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentDetails")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 779842745023240139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stuId;
	
	@Column(name="Student_Name")
	private String stuName;
	
	@Column(name="Student_Last_Name")
	private String stuLname;
	
	@Column(name="Student_Course")
	private String stuCourse;
	
	@Column(name="Student_Mobile_Number")
	private String stuMobile;
	
	@Column(name="Student_EmailId")
	private String stuEmail;
	
	@Column(name="Student_StudentEntryDate")
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

	public Student(Integer stuId, String stuName, String stuLname, String stuCourse, String stuMobile, String stuEmail,
			Date stuEntryDate) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuLname = stuLname;
		this.stuCourse = stuCourse;
		this.stuMobile = stuMobile;
		this.stuEmail = stuEmail;
		this.stuEntryDate = stuEntryDate;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
