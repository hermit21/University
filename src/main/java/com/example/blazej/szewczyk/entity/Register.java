package com.example.blazej.szewczyk.entity;





public class Register {
	
	
	private String name;

	private String surname;

	private String address;

	private String faculty;

	private String specialization;

	private String username;

	private String password;

	private String repeat_password;
		
	public Register() {}
	public Register(String name, String surname, String address, String faculty, String specialization, String username, String password, String repeat_password) {		
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.faculty = faculty;
		this.specialization = specialization;
		this.username = username;
		this.password = password;
		this.repeat_password = repeat_password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}
	/**
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the repeat_password
	 */
	public String getRepeat_password() {
		return repeat_password;
	}
	/**
	 * @param repeat_password the repeat_password to set
	 */
	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}
}
