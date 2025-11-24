package com.hostel.hostel_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "rooms", uniqueConstraints = @UniqueConstraint(columnNames = {"room_number"}))
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_number",nullable = false,unique = true)
	private String roomNumber;
	
	@Column(name = "room_type",nullable = false)
	private String roomtype;
	
	@Column(nullable = false)
	private int capacity;
	
	@Column(nullable = false)
	private int occupied;
	
	@Column(name = "price_per_month",nullable = false)
	private double pricePerMonth;
	
	@Column(nullable = false)
	private String status;
	
	//Constructor
	public Room(Long id, String roomNumber, String roomtype, int capacity, int occupied, double pricePerMonth,
			String status) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomtype = roomtype;
		this.capacity = capacity;
		this.occupied = occupied;
		this.pricePerMonth = pricePerMonth;
		this.status = status;
	}
	
	//Getter-Setter

	public Long getId() {
		return id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getOccupied() {
		return occupied;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}
