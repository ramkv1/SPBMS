package com.rk.dao;

import com.rk.model.Employee;

public interface IEmployeeDAO {
	public int insert(Employee emp) throws Exception;
	public Object findByID(int id)throws Exception;
	
}
 