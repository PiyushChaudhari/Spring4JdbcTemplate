package com.web.application.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.application.dao.EmployeeDao;
import com.web.application.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		Random rand = new Random();
		employee.setId(rand.nextInt(50));
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee, employee.getId());
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	@Override
	public Employee get(Integer id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeDao.list();
	}

}
