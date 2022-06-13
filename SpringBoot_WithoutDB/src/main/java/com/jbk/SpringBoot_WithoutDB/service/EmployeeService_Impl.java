package com.jbk.SpringBoot_WithoutDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.SpringBoot_WithoutDB.dao.EmployeeDao;
import com.jbk.SpringBoot_WithoutDB.entity.Employee;

@Service
public class EmployeeService_Impl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public String saveEmployee(Employee employee) {
		
		String msg = dao.saveEmployee(employee);
		return msg;
	}

	public List<Employee> getAllEmployee()
	{
		return dao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeByPathVariable(int eid) {
		
		Employee employee = dao.getEmployeeByPathVariable(eid);
		
		return employee;
	}

	@Override
	public String deleteEmployeeById(int eid) {
		
		return dao.deleteEmployeeById(eid);
	}

	@Override
	public Employee getupdatedEmployee(Employee employee) {
		
		Employee emp = dao.getupdatedEmployee(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployeeSortedBySalary() {
		
		return dao.getAllEmployeeSortedBySalary();
	}
	
}
