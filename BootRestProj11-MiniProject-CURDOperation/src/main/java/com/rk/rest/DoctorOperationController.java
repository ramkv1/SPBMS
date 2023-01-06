package com.rk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.Doctor;
import com.rk.service.IDoctorMgmtService;

@RestController
@RequestMapping("/doctor")
public class DoctorOperationController {
	
	@Autowired
	private IDoctorMgmtService doctorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registorDoctor(@RequestBody Doctor doctor){
		
		try {
			//use service
			String resultMsg=doctorService.registerDoctor(doctor);
			//return ResponseEntity Object
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Problem in Doctor Registration",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//=======SELECT OPERATIONS==========
	@GetMapping("/report")
	public ResponseEntity<?> showAllDoctors(){
	try {
		List<Doctor> list=doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	}
	catch (Exception e) {
		return new ResponseEntity<String>("Problem in Getting Records",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	}
	//================
	
	/*	@GetMapping("/find/{id}")
		public ResponseEntity<?> fetchDoctorById(@PathVariable int id){
			try {
				//use service
				Doctor doctor=doctorService.getDoctorById(id);
				return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
			}//try
			catch(Exception e) {
				return new ResponseEntity<String>("Problem in Getting Records",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}*/
	
	//ExceptionHandling using CustomException class
	
		@GetMapping("/find/{id}")
		public ResponseEntity<?> fetchDoctorById(@PathVariable int id){
			try {
				//use service
				Doctor doctor=doctorService.getDoctorById(id);
				return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
			}//try
			catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//===========
		@PutMapping("/modify")
		public ResponseEntity<?> modifyDoctorInfo(@RequestBody Doctor doctor){
			try {
				//use service
				String resultMsg=doctorService.updateDoctor(doctor);
				return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
				
			}//try
			catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		
		//==============delete operation===========
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> removeDoctorById(@PathVariable Integer id){
			try {
				//use service
				String resultMsg=doctorService.deleteDoctorById(id);
				return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
				
			}//try
			catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
		@DeleteMapping("/deleteByIncome/{start}/{end}")
		public ResponseEntity<String> removeDoctorById(@PathVariable double start,@PathVariable double end){
			try {
				//use service
				String msg=doctorService.deleteDoctorsByIncomeRange(start, end);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		///==========================
		@PatchMapping("/update/{id}/{percentage}")
		public ResponseEntity<String> updateIncomeOfDoctor(@PathVariable int id,@PathVariable double percentage){
			try {
				//use service
				String msg=doctorService.hikeDoctorIncomeByPercentage(id, percentage);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
			
		
}






















