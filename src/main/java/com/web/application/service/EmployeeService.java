package com.web.application.service;

import java.util.List;

import com.web.application.model.Employee;

public interface EmployeeService {

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(Integer id);

	public Employee get(Integer id);

	public List<Employee> list();
}
