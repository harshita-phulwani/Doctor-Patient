package com.doctor.doctorpatient.services;

import java.util.List;

import com.doctor.doctorpatient.model.Doctor;
import com.doctor.doctorpatient.model.Patient;

public interface DoctorService {
	public List<Doctor> getDoctors();
	public Doctor add(Doctor doctor);
	public void remove(Long id);
	public List<Doctor> suggestDoctors(Patient patient);
}
