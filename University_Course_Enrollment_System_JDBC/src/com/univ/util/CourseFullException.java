package com.univ.util;

public class CourseFullException extends Exception{
	public String toString() {
		return "Course Full: " + getMessage();
		
	}
}
