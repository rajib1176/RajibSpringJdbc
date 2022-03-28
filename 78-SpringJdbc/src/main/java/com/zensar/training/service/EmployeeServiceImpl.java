package com.zensar.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zensar.training.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeService service;

	@Override
	public boolean addEmployee(Employee employee) throws Exception {
		return this.service.addEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) throws Exception {
		return this.service.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws Exception {
		return this.service.deleteEmployee(employee);
	}

	@Override
	public Employee findEmployee(int id) throws Exception {
		return this.service.findEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployee() throws Exception {
		return this.service.findAllEmployee();
	}

}
