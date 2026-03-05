package com.example.Smart.Hospital.Management.System.service;

import java.util.List;

import com.example.Smart.Hospital.Management.System.entities.Doctor;

public interface DoctorService {
	
	public Doctor addDoctor(Doctor doctor);
	
	public Doctor updateDoctor(Doctor doctor, Long id);
	
	public Doctor deleteDoctor(Long id);
	
	public List<Doctor> getSingleDoctorBySpecialization(String specialization);
	
	public List<Doctor> getAllDoctor();

}
