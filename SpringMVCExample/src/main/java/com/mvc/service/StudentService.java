package com.mvc.service;

import com.mvc.model.Student;

public interface StudentService {
	public abstract Student validateStudentCredential(String email,	String password);
	public abstract boolean registerStudent(Student student);

}