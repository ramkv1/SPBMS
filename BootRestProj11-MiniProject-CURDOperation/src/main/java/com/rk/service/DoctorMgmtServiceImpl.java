package com.rk.service;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rk.entity.Doctor;
import com.rk.exception.DoctorNotFoundException;
import com.rk.repository.IDoctorRepo;


@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		
		int idVal=doctorRepo.save(doctor).getDocid();
		return "Doctor is saved with the id value::"+idVal;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list=doctorRepo.findAll();
		list.sort((d1,d2)->d1.getDocName().compareTo(d2.getDocName()));
		return list;
	}



	/*	@Override
		public Doctor getDoctorById(int id) {
			Doctor doc=doctorRepo.findById(id).get();
			return doc;
		}*/
	
	@Override
	public Doctor getDoctorById(int id) throws DoctorNotFoundException {
		Doctor doc=doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException(id+"::ID Doctor is not Found"));
		return doc;
	}

	@Override
	public String updateDoctor(Doctor doctor) throws DoctorNotFoundException {
		//Find the Obj
		Optional<Doctor> opt=doctorRepo.findById(doctor.getDocid());
		if(opt.isPresent()) {
			//update the Obj
			doctorRepo.save(doctor);//performs update operation if the object/record already present
			return doctor.getDocid()+"Doctor details are updated";
		}
		else {
			throw new DoctorNotFoundException(doctor.getDocid()+"::Doctor is Not Found");
		}
	}

	@Override
	public String deleteDoctorById(int docId) throws DoctorNotFoundException {
		//get find the object
		Optional<Doctor> opt=doctorRepo.findById(docId);
		if(opt.isPresent()) {
			doctorRepo.deleteById(docId);
			return docId+"::id doctor is deleted";
		}
		else {
			throw new DoctorNotFoundException(docId+"::Doctor is not Found");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteDoctorsByIncomeRange(double start, double end) {
		//use service
		int count=doctorRepo.deleteDoctorByIncomeRange(start, end);
		
		return count+"=>No.of doctor are deleted";
	}

	@Override
	public String hikeDoctorIncomeByPercentage(int docid, double percentage) throws DoctorNotFoundException {
		//load the obj
		Optional<Doctor> opt=doctorRepo.findById(docid);
		if(opt.isPresent()) {
			Doctor doctor=opt.get();
			doctor.setIncome(doctor.getIncome()+(doctor.getIncome()*percentage/100.0));
			
			//Use repo
			doctorRepo.save(doctor);//update the object
			return "Doctor income is hiked"+doctor.getIncome();
		}
		else {
			throw new DoctorNotFoundException(docid+"=>doctor is not found");
		}
	}
	


}
