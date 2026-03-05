package com.example.Smart.Hospital.Management.System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Smart.Hospital.Management.System.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long>{
	

	public List<Doctor> findBySpecialization(String specialization);

}
