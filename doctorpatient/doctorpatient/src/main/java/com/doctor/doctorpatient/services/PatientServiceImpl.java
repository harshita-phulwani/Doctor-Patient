package com.doctor.doctorpatient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.doctorpatient.model.Patient;
import com.doctor.doctorpatient.repository.PatRepo;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
    private PatRepo patRepo;
	
	@Override
	public List<Patient> getAllPatients() {
		return patRepo.findAll();
	}

    public Patient addPatient(Patient patient) {
        return patRepo.save(patient);
    }


	public void removePatient(Long id) {
        patRepo.deleteById(id);
    }

	public Patient getPatientById(Long id) {
        return patRepo.findById(id).orElse(null);
    }

}
