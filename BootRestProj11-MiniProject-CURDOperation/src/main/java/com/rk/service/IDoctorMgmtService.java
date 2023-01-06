package com.rk.service;

import java.util.List;

import com.rk.entity.Doctor;
import com.rk.exception.DoctorNotFoundException;


public interface IDoctorMgmtService {
	public String registerDoctor(Doctor doctor);
	public List<Doctor> getAllDoctors();
	public Doctor getDoctorById(int id) throws DoctorNotFoundException;
	public String updateDoctor(Doctor doctor) throws DoctorNotFoundException;
	public String deleteDoctorById(int docId) throws DoctorNotFoundException;
	public String deleteDoctorsByIncomeRange(double start,double end);
	public String hikeDoctorIncomeByPercentage(int docid,double percentage) throws DoctorNotFoundException;
}
