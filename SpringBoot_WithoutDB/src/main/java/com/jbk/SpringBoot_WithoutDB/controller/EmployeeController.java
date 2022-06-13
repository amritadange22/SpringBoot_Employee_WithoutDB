package com.jbk.SpringBoot_WithoutDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.SpringBoot_WithoutDB.entity.Employee;
import com.jbk.SpringBoot_WithoutDB.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping(value="/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee)
	{
		String msg = service.saveEmployee(employee);
		return msg;
	}
	
	@GetMapping(value="/getAllEmployee")
	public List<Employee> getAllEmployee()
	{
		List<Employee> employees= service.getAllEmployee();

		//employees.forEach(employee->System.out.println(employee));
		
		return employees;
		
	}
	
	@GetMapping(value="/getEmployeeByPathVariable/{eid}")
	public Object getEmployeeByPathVariable(@PathVariable int eid)
	{
		Employee employee = service.getEmployeeByPathVariable(eid);
		
		if(employee!=null)
			return employee;
		else
			return "Record not found!!!";
		
	}
	
	@GetMapping(value="/getEmployeeByRequestParam")
	public Object getEmployeeByRequestParam(@RequestParam int eid)
	{
		Employee employee = service.getEmployeeByPathVariable(eid);
		
		if(employee!=null)
			return employee;
		else
			return "Record not found!!!";
		
	}
	
	@DeleteMapping(value="/deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam int eid)
	{
			return service.deleteEmployeeById(eid);
	}
	
	@PutMapping(value="/getupdatedEmployee")
	public Object getupdatedEmployee(@RequestBody Employee employee)
	{
		Employee emp = service.getupdatedEmployee(employee);
		
		if(emp!=null)
			return emp;
		else
			return "Record not found!!!";	
	}
	
	@GetMapping(value="/getAllEmployeeSortedBySalary")
	public List<Employee> getAllEmployeeSortedBySalary()
	{
		List<Employee> employees= service.getAllEmployeeSortedBySalary();

		//employees.forEach(employee->System.out.println(employee));
		
		return employees;
		
	}
}
