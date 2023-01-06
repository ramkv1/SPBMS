package com.rk.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empno;
	private String ename;
	private String desg;
	private Double salary;
	
	//getters and setters
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	//ToString Method
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", desg=" + desg + ", salary=" + salary + "]";
	}
	
	
	
}

