package com.hostel.hostel_management.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private String phone;
	
	@Column(nullable = false)
	private String role;
	
	@Column
	private String address;
	
	@Column(name = "join_date", columnDefinition = "DATE")
	private LocalDate joinDate;
	
	
	//Constructor
	public User(Long id, String name, String email, String password, String phone, String role, String address,
			LocalDate joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.address = address;
		this.joinDate = joinDate;
	}
	
	//getters-Setters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getRole() {
		return role;
	}

	public String getAddress() {
		return address;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
