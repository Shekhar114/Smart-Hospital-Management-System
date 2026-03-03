package com.example.Smart.Hospital.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Smart.Hospital.Management.System.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
