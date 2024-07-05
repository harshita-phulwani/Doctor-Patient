package com.doctor.doctorpatient.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.doctorpatient.model.Doctor;
import com.doctor.doctorpatient.model.Doctor.Speciality;
import com.doctor.doctorpatient.model.Patient;
import com.doctor.doctorpatient.model.Patient.Symptom;
import com.doctor.doctorpatient.repository.DocRepo;

@Service

public class DoctorServiceImpl implements DoctorService {

	
	@Autowired
	private DocRepo docRepo;
	
	
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return docRepo.findAll();
	}

	@Override
	public Doctor add(Doctor doctor) {
		// TODO Auto-generated method stub
		return docRepo.save(doctor);
	}

	@Override
	public void remove(Long id) {
		docRepo.deleteById(id);
		
	}

	@Override
	public List<Doctor> suggestDoctors(Patient patient){
        Speciality speciality = mapSymptomToSpeciality(patient.getSymptom());
        List<Doctor> doctors = docRepo.findByCityAndSpeciality(patient.getCity(), speciality);
        if (doctors.isEmpty()) {
            System.out.print ("There isn’t any doctor present at your location for your symptom");
        }
        return doctors;
    }
	
    public Speciality mapSymptomToSpeciality(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT;
            default:
                throw new IllegalArgumentException("Invalid symptom");
        }
    }

}
