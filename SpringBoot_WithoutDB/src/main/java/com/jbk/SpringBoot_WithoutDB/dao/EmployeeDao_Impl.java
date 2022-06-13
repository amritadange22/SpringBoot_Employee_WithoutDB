package com.jbk.SpringBoot_WithoutDB.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.jbk.SpringBoot_WithoutDB.entity.Employee;

@Repository
public class EmployeeDao_Impl implements EmployeeDao
{
	List<Employee> list = new ArrayList<>();
	
	@Override
	public String saveEmployee(Employee employee) {
		
		list.add(employee);
		return "Employee Details Saved!!!";
	}
	
	public List<Employee> getAllEmployee()
	{
		return list;
	}

	@Override
	public Employee getEmployeeByPathVariable(int eid) {
		
		Employee employee = null;
		
		for (Employee emp : list) 
		{
			if(emp.getEid()==eid)
			{
				employee=emp;
				break;
			}
		}
		
		return employee;
	}

	@Override
	public String deleteEmployeeById(int eid) {

		for (Employee emp : list) 
		{
			if(emp.getEid()==eid)
			{
				list.remove(emp);
				//list.remove(eid);
				return "Record deleted!!!";
			}
		}
		return "Record not found!!!";
	}

	@Override
	public Employee getupdatedEmployee(Employee employee) {
		
		for (Employee emp : list) 
		{
			if(emp.getEid()==employee.getEid())
			{
				list.remove(emp);
				list.add(employee);
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployeeSortedBySalary() {
		
		list.sort((e1,e2)->
		{
			Double s1=e1.getSalary();
			Double s2=e2.getSalary();
			return s1.compareTo(s2);
		});
		
		return list;
	}
}
