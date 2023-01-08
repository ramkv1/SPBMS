package com.rk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO EMPLOYEE_INFO(ENAME,DESG,SALARY) VALUES(?,?,?)";
	private static final String FETCH_EMPLOYEE_QUERY="SELECT * FROM EMPLOYEE_INFO WHERE ENO=";
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
			if(rs.next()) {
				Ename=rs.getString(2);
			}
			return "Employee Name with given id::"+Ename;
			
		}catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}

	}
	
}//main
