package com.rk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk.Exception.EmplyeeNotFoundException;
import com.rk.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO EMPLOYEE_INFO(ENAME,DESG,SALARY) VALUES(?,?,?)";
	private static final String FETCH_EMPLOYEE_QUERY="SELECT * FROM EMPLOYEE_INFO WHERE ENO=";
	private static final String DELETE_EMPLOYEE_QUERY="DELETE FROM EMPLOYEE_INFO WHERE ENO =";
	@Autowired
	private DataSource ds;
	
	
	@Override
	public int insert(Employee emp) throws Exception {
		System.out.println(ds.getClass());
		int count=0;
		try(
		//get pooled jdbc con obj
		Connection con=ds.getConnection();
		//create PreparedStatement obj having pre-compiled Sql Query
		PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);){
			//set values to Query paramsfindById
			ps.setString(1,emp.getEname());
			ps.setString(2,emp.getDesg());
			ps.setDouble(3,emp.getSalary());
			
			//execute the Query
			count=ps.executeUpdate();
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
			//exception re throwing
		}
		return count;
	}//method

//================================================================================================

	@Override
	public String findByID(int id) throws Exception {
		try {
			Connection con=ds.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(FETCH_EMPLOYEE_QUERY+id);
			String Ename="";
			while(rs.next()) {
				Ename=rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4);
			}
			return "Employee Details are:"+Ename;
			
		}catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}

	}
//=====================================================================================================

@Override
public String deleteById(int id) throws EmplyeeNotFoundException {

	try {
		Connection con=ds.getConnection();
		Statement st=con.createStatement();
		st.execute(DELETE_EMPLOYEE_QUERY+id);
		return id+"::are Deleted From Table";
	} catch (SQLException se) {
		se.printStackTrace();
		return null;
	}
}
	
	
}//main
