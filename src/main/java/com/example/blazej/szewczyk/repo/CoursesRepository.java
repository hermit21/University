package com.example.blazej.szewczyk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blazej.szewczyk.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
