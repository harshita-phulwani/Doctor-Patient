package com.doctor.doctorpatient.model;

import com.doctor.doctorpatient.model.Doctor.City;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PatientID;
	
	
	private String Name;
	
	
    private  City city;

    
    private String email;

    
    private String phoneNumber;

    
    private Symptom symptom;
	
	public Patient(Long patientID, String name, City city, Symptom symptoms, String phone_number, String email) {
		super();
		PatientID = patientID;
		Name = name;
		this.city = city;
		this.symptom = symptoms;
		this.phoneNumber = phone_number;
		this.email = email;
	}
	public Patient() {
		super();
	}
	
	public enum Symptom {
	    ARTHRITIS, BACK_PAIN, TISSUE_INJURIES,
	    DYSMENORRHEA,
	    SKIN_INFECTION, SKIN_BURN,
	    EAR_PAIN
	}
	
	public Long getPatientID() {
		return PatientID;
	}
	public void setPatientID(Long patientID) {
		PatientID = patientID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Symptom getSymptom() {
		return symptom;
	}
	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}
	
	
	
	
}

