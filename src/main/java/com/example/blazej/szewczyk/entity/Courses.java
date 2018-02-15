package com.example.blazej.szewczyk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	
	private String course_name;
	
	private String description;
	
	private String instructor;
	

	
	public Courses(){}
	
	public Courses(String course_name, String description, String instructor) {
		
		super();
		this.course_name = course_name;
		this.description = description;
		this.instructor = instructor;
		
	}

	/**
	 * @return the course_name
	 */
	public String getCourse_name() {
		return course_name;
	}

	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

}
