package com.example.ContactMangementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_details")
public class Contact {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String phoneNo;
	private String email;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String phoneNo, String email) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
