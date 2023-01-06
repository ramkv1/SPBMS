package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.EmployeeDAOImpl;
import com.rk.dao.IEmployeeDAO;
import com.rk.model.Employee;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	@Override
	public String registerEmployee(Employee employee) {
		
		return "Employee is saved with the id values::";
	}

}
