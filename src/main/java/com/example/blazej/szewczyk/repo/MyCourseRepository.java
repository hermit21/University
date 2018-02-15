package com.example.blazej.szewczyk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blazej.szewczyk.entity.MyCourse;

public interface MyCourseRepository extends JpaRepository<MyCourse, Integer> {

	
}
