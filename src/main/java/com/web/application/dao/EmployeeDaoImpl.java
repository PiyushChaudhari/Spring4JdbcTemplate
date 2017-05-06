package com.web.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.application.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Employee employee) {
		jdbcTemplate.update("INSERT INTO employee (id, firstName, lastName,email) VALUES (?, ?, ?, ?)",
				employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
		System.out.println("Employee Save!!");
	}

	@Override
	public void update(Employee employee, Integer id) {
		jdbcTemplate.update("UPDATE employee SET firstName = ? , lastName = ? , email = ? WHERE id = ? ",
				employee.getFirstName(), employee.getLastName(), employee.getEmail(), id);
		System.out.println("Employee Updated!!");

	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("DELETE from employee WHERE id = ? ", id);
		System.out.println("Employee Deleted!!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee get(Integer id) {
		@SuppressWarnings("rawtypes")
		Employee employee = (Employee) jdbcTemplate.queryForObject("SELECT * FROM employee where id = ? ",
				new Object[] { id }, new BeanPropertyRowMapper(Employee.class));
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> list() {
		@SuppressWarnings("rawtypes")
		List<Employee> employees = jdbcTemplate.query("SELECT * FROM employee",
				new BeanPropertyRowMapper(Employee.class));
		return employees;
	}

}
