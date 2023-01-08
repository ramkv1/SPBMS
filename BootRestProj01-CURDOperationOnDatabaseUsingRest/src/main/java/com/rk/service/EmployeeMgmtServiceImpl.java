package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Exception.EmplyeeNotFoundException;
import com.rk.dao.EmployeeDAOImpl;
import com.rk.model.Employee;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	@Override
	public String registerEmployee(Employee employee) {
		
		try {
			employeeDAOImpl.insert(employee);
			return "Employee is saved with the id values::"+employee.getEname();
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Employee Details are Not Found";
		}
		
	}
	

	@Override
	public String getEmployeeById(int id) throws EmplyeeNotFoundException {
		try {
			String employee=employeeDAOImpl.findByID(id);
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			return "Employee Details are Not Found";
		}
		
	}


}
