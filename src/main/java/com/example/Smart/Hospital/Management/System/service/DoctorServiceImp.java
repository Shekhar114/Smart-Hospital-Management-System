package com.example.Smart.Hospital.Management.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Smart.Hospital.Management.System.entities.Doctor;
import com.example.Smart.Hospital.Management.System.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorServiceImp implements DoctorService{
	
	@Autowired
	private DoctorRepository repo;

	@Transactional
	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		
		
		return repo.save(doctor);
	}
	

	@Override
	public Doctor updateDoctor(Doctor doctor, Long id) {
		
		Doctor d = repo.findById(id).orElseThrow(() -> new RuntimeException("Id is not match in db"));
		if(!doctor.getName().equals(null)) {
			d.setName(doctor.getName());
		}
		
		d.setExperience(doctor.getExperience());
		d.setAvailabilityStatus(doctor.getAvailabilityStatus());
		d.setConsultationFee(doctor.getConsultationFee());
		d.setSpecialization(doctor.getSpecialization());
		d.setAppointments(doctor.getAppointments());
		
		return repo.save(d);
	}

	@Override
	public Doctor deleteDoctor(Long id) {
		Doctor d = repo.findById(id).orElseThrow(() -> new RuntimeException("It's Id not present in db"));
		repo.deleteById(id);
		return d;
	}

	@Override
	public List<Doctor> getSingleDoctorBySpecialization(String specialization) {
		
		return repo.findBySpecialization(specialization);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		
		return repo.findAll();
	}

}
