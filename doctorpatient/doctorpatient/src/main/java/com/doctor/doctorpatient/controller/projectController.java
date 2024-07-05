package com.doctor.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.doctorpatient.model.Doctor;
import com.doctor.doctorpatient.model.Patient;
import com.doctor.doctorpatient.services.DoctorService;
import com.doctor.doctorpatient.services.PatientService;

@RestController

public class projectController {
	
	@Autowired
	public DoctorService doctorService;
		
	@PostMapping("/addDoctor")
    public Doctor add(@RequestBody Doctor doctor) {
        return doctorService.add(doctor);
    }

    @DeleteMapping("/removeDoctor/{id}")
    public void remove(@PathVariable Long id) {
        doctorService.remove(id);
    }
    
    @Autowired
    private PatientService patientService;
    

    @GetMapping("/ListofPatients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/ListofDoctors")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("{patId}/suggestionOfDoctor")
    public List<Doctor> suggestDoctors(@PathVariable Long patId) {
        Patient patient = patientService.getPatientById(patId);

        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }

        return doctorService.suggestDoctors(patient);
    }
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/removePatient/{id}")
    public void removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
    }

}
