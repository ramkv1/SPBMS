package com.rk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Exception.EmplyeeNotFoundException;
import com.rk.model.Employee;
import com.rk.service.IEmployeeMgmtService;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationRestController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@PostMapping("/registor")
	public ResponseEntity<String> registor(@RequestBody Employee employee){
		try {
		//use service
		String resultMsg=service.registerEmployee(employee);
		//Return ResponseEntity Object
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in employee registration",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
	
//================================================
	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> FetchEmployeeDetails(@PathVariable int id){
		try {
			String resultQuery=(String) service.getEmployeeById(id);
			
			return new ResponseEntity<String>(resultQuery,HttpStatus.OK);
		} catch (EmplyeeNotFoundException e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>("",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
