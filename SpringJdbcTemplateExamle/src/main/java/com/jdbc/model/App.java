package com.jdbc.model;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.JDBCEmployeeDAO;

	
	



public class App {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
	
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
			JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context.getBean("jdbcEmployeeDAO");
			
			/*Employee employee=new Employee(116,"Sujesh", 39);
			jdbcEmployeeDAO.createEmployee(employee);*/
			
			/*Employee employee1 = jdbcEmployeeDAO.getEmployeeById(112);
			System.out.println(employee1);*/
			
			List<Employee> empList = jdbcEmployeeDAO.getAllEmployeesDetails();
			for (Employee employee : empList) {
				System.out.println(employee);
			}
			
			//jdbcEmployeeDAO.deleteEmployeeById(123);
			jdbcEmployeeDAO.updateEmployeeNameById("New_Name", 128);
			}
	}




