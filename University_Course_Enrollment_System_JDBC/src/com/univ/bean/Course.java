package com.univ.bean;

public class Course {
	private String courseID;
	private String courseTitle;
	private int credits;
	private int capacity;
	private int enrolledCount;
	public String getCourseID() {
		return courseID;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public int getCredits() {
		return credits;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getEnrolledCount() {
		return enrolledCount;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setEnrolledCount(int enrolledCount) {
		this.enrolledCount = enrolledCount;
	}
	
}
