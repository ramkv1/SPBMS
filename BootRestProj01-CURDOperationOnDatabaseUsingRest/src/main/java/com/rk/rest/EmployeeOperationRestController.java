package com.rk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
