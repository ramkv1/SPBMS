package com.rk.dao;

import com.rk.Exception.EmplyeeNotFoundException;
import com.rk.model.Employee;

public interface IEmployeeDAO {
	public int insert(Employee emp) throws Exception;
	public String findByID(int id)throws Exception;
	public String deleteById(int id)throws EmplyeeNotFoundException;
	
}
 