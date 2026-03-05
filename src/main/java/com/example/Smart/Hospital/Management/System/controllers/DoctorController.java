package com.example.Smart.Hospital.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Smart.Hospital.Management.System.entities.Doctor;
//import com.example.Smart.Hospital.Management.System.service.DoctorService;
import com.example.Smart.Hospital.Management.System.service.DoctorServiceImp;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorServiceImp service;
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor)
	{	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addDoctor(doctor));	
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.updateDoctor(doctor, id));
	}

	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteDoctor(id));
		
	}
	
	@GetMapping({"/specilization"})
	public ResponseEntity<List<Doctor>> getDoctorWithSpecifiaction(@PathVariable String specilization){
		
		return ResponseEntity.ok(service.getSingleDoctorBySpecialization(specilization));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		return ResponseEntity.ok(service.getAllDoctor());
	}
	
}
