package com.doctor.doctorpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.doctorpatient.model.Doctor;
import com.doctor.doctorpatient.model.Doctor.City;
import com.doctor.doctorpatient.model.Doctor.Speciality;

public interface DocRepo extends JpaRepository<Doctor, Long> {
	
	 List<Doctor> findByCityAndSpeciality (City city, Speciality speciality);
}
