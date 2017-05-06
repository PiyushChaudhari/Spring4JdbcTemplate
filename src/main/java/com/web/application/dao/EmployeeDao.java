package com.web.application.dao;

import java.util.List;

import com.web.application.model.Employee;

public interface EmployeeDao {

	public void save(Employee employee);

	public void update(Employee employee, Integer id);

	public void delete(Integer id);

	public Employee get(Integer id);

	public List<Employee> list();
}
