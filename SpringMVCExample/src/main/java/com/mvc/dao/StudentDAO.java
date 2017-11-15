package com.mvc.dao;

import com.mvc.model.Student;

public interface StudentDAO {
	public abstract boolean saveStudent(Student student);
	public Student getStudentDetailsByEmailAndPassword(String email,String password);
}
