package com.univ.util;

public class ActiveEnrollmentException extends Exception{
	public String toString() {
		return "Activation Enrollment Exists:" +getMessage();
	}
}
