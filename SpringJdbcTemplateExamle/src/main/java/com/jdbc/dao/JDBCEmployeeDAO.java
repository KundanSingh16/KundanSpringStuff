package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Employee;

public interface JDBCEmployeeDAO {
	
	public abstract void  createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer id);
	public abstract void deleteEmployeeById(Integer id);
	public abstract void updateEmployeeNameById(String name,int id);
	public abstract List<Employee> getAllEmployeesDetails();
	

}
