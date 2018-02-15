package com.example.blazej.szewczyk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_course")
public class MyCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String course_name;
	
	private String course_instructor;
	
	private String student_id;
	
	private String status;
	
	public MyCourse() {}
	
	public MyCourse(String course_name, String course_instructor, String student_id, String status) {
		super();
		this.course_name = course_name;
		this.course_instructor = course_instructor;
		this.student_id = student_id;
		this.status = status;
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
	 * @return the course_number
	 */
	public String getCourse_instructor() {
		return course_instructor;
	}

	/**
	 * @param course_number the course_number to set
	 */
	public void setCourse_instructor(String course_instructor) {
		this.course_instructor = course_instructor;
	}

	/**
	 * @return the student_id
	 */
	public String getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
