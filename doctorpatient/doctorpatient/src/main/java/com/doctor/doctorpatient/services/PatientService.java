package com.doctor.doctorpatient.services;

import java.util.List;

import com.doctor.doctorpatient.model.Patient;

public interface PatientService {
	public List<Patient> getAllPatients();

	public Patient addPatient(Patient patient);

	public void removePatient(Long id);

	public Patient getPatientById(Long id);

}
