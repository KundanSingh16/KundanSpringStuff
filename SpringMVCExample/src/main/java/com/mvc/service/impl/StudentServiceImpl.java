package com.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.StudentDAO;
import com.mvc.model.Student;
import com.mvc.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	
	public boolean registerStudent(Student student) {
		boolean isRegister=false;
		boolean saveStudent = getStudentDAO().saveStudent(student);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}

	
	public Student validateStudentCredential(String email,	String password) {
		Student student = getStudentDAO().getStudentDetailsByEmailAndPassword(email, password);
		return student;
	}
}
