package com.example.blazej.szewczyk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blazej.szewczyk.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findOneByName(String name);

	Student findByFaculty(String faculty);
	
	Student findByUsername(String username);
	
	Student findByPassword(String password);

}
