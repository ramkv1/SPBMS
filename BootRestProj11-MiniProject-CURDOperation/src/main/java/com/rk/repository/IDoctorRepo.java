package com.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rk.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	@Modifying
	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")//HQL query
	public int deleteDoctorByIncomeRange(double start,double end);
}
