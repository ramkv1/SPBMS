package com.rk.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTOR_INFO1")
public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOC_ID")
	private Integer docid;
	@Column(length = 20,name = "DOC_NAME")
	private String docName;
	@Column(length = 20,name = "SPECIALIZATION")
	private String specialization;
	@Column(name = "INCOME")
	private Double income;

	//getters and setters
	public Integer getDocid() {
		return docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
		
	//toString
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", docName=" + docName + ", specialization=" + specialization + ", income="
				+ income + "]";
	}
}
