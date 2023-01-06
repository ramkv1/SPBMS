package com.rk;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.rk.controller.PayrollOperationController;
import com.rk.model.Employee;

@SpringBootApplication
@ImportResource("com/rk/cfgs/applicationContext.xml")
public class BootProj04LayeredAppRealtimeDiForMultipleDbApplication {

	public static void main(String[] args) {
		
		//read inputs from the end user
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee name::");
		String name=sc.next();
		System.out.println("Enter employee dsg::");
		String desg=sc.next();
		System.out.println("Enter employee basicSalary:;");
		double basicSalary=sc.nextDouble();
		//Create the Employee class object
		Employee emp=new Employee();
		emp.setDesg(desg);
		emp.setEname(name);
		emp.setSalary(basicSalary);
		
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj04LayeredAppRealtimeDiForMultipleDbApplication.class, args);
		//get controller class object
		PayrollOperationController controller=ctx.getBean("payrollController",PayrollOperationController.class);
		//invoke the method
		try {
			String result=controller.processEmployee(emp);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--Try again"+e.getMessage());
		}
		//close the container
		((ConfigurableApplicationContext) ctx).close();
				
	}//main

}
