package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")//table in db
public class Student {
	
	@Id
	@Column(name="student_id")//mapping with table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int studentId;
	
	@Column(name="student_name", nullable = false)
	private String studentName;
	
	@Column(name = "student_address",nullable = false)
	private String studentAddress;
	
	@Column(name = "student_mobile",nullable = false)
	private long studentMobile;

	
	public int getStudentId() {
		return studentId;
	}
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student( String studentName, String studentAddress, int studentMobile) {
		super();
		
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentMobile = studentMobile;
	}
	
	

}

