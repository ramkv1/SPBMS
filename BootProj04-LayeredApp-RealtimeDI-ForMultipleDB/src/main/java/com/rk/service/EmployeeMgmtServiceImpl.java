package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rk.dao.IEmployeeDAO;
import com.rk.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	@Qualifier("finalDAO")
	private IEmployeeDAO empDAO;
	
	@Override
	public String registerEmployee(Employee emp) throws Exception {
		// calculate grossSalary and netSalary
		double grossSalary=emp.getSalary()+(emp.getSalary()*0.2f);
		double netSalary=grossSalary-(grossSalary*0.2f);
		//set grossSalary,netSalary to Employee class Object
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
		//use DAO
		int count=empDAO.insert(emp);
		
		
		return count==0?"Employee registration failed":"Employee registered and the salary=="+emp.getSalary()+"----------GrossSalary=="+emp.getGrossSalary()+"-----------NetSalary=="+emp.getNetSalary();
	}

}
