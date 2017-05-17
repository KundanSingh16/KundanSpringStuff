package com.jdbc.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.dao.JDBCEmployeeDAO;
import com.jdbc.model.Employee;
import com.jdbc.model.EmployeeRowMapper;

public class JDBCEmployeeDaoImpl implements JDBCEmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createEmployee(Employee employee) {

		String sql = "INSERT INTO employee " + "(ID,NAME,AGE) VALUES (?,?,?)";

		// jdbcTemplate.update(sql, new Object[]{employee.getId(),
		// employee.getName(), employee.getAge()});
		// System.out.printf("Employee Record Created: " +employee.getId()+ ","
		// +employee.getName()+"," +employee.getAge());

	}

	public Employee getEmployeeById(Integer id) {

		String sql = "SELECT * FROM employee WHERE id = ?";

		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { id }, new EmployeeRowMapper());
		// Employee employee = (Employee)jdbcTemplate.queryForObject(sql, new
		// Object[]{id},new BeanPropertyRowMapper(Employee.class));

		return employee;
	}

	public void deleteEmployeeById(Integer id) {
		
		String SQL="DELETE FROM employee WHERE id=?";
		int update = jdbcTemplate.update(SQL, id);
		if(update>0)
			System.out.println("Employee is deleted..");

	}

	public void updateEmployeeNameById(String name, int id) {
		String SQL="UPDATE employee set name=? WHERE id=?";
		int update = jdbcTemplate.update(SQL, name,id);
		if(update>0)
			System.out.println("Name is updated..");

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployeesDetails() {
		String SQL = "SELECT * FROM employee";

		return jdbcTemplate.query(SQL, new EmployeeRowMapper());
	}

}
