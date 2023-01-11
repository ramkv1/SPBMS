package com.rk.service;

import com.rk.Exception.EmplyeeNotFoundException;
import com.rk.model.Employee;

public interface IEmployeeMgmtService {
	public String registerEmployee(Employee employee) throws Exception;
	public String getEmployeeById(int id) throws EmplyeeNotFoundException;
	public String DeleteEmployeeBYId(int id)throws EmplyeeNotFoundException;
}
