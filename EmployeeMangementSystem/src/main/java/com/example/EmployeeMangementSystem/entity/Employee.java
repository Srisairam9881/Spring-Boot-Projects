package com.example.EmployeeMangementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String age;
	private String gender;
	private String email;
	private String department;
	private String graduation;
	private float ten_per;
	private float inter_per;
	private float btech_percentage;
	public Employee()
	{
		
	}
	public Employee(String fullName, String age, String gender, String email, String department,
			String graduation, float ten_per, float inter_per, float btech_percentage) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.department = department;
		this.graduation = graduation;
		this.ten_per = ten_per;
		this.inter_per = inter_per;
		this.btech_percentage = btech_percentage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public float getTen_per() {
		return ten_per;
	}
	public void setTen_per(float ten_per) {
		this.ten_per = ten_per;
	}
	public float getInter_per() {
		return inter_per;
	}
	public void setInter_per(float inter_per) {
		this.inter_per = inter_per;
	}
	public float getBtech_percentage() {
		return btech_percentage;
	}
	public void setBtech_percentage(float btech_percentage) {
		this.btech_percentage = btech_percentage;
	}

	

}
