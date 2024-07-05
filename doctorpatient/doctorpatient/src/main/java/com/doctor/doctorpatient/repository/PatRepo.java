package com.doctor.doctorpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.doctorpatient.model.Patient;

public interface PatRepo extends JpaRepository<Patient, Long> {

}
