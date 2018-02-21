package com.example.blazej.szewczyk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.blazej.szewczyk.entity.MyCourse;

public interface MyCourseRepository extends JpaRepository<MyCourse, Integer> {

	@Query("SELECT t FROM MyCourse t where t.student_id = :student_id")
	MyCourse findBy(@Param("student_id") String student_id);

}
