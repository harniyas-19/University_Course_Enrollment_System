package com.univ.bean;

import java.util.Date;

public class Enrollment {
	private int enrollmentID;
	private String courseID;
	private String studentID;
	private String studentName;
	private Date enrollmentDate;
	private String status;
	public int getEnrollmentID() {
		return enrollmentID;
	}
	public String getCourseID() {
		return courseID;
	}
	public String getStudentID() {
		return studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
