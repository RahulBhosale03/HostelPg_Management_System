package com.hostel.hostel_management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;	//Customer
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "room_id")
	private Room room;	//Room Assigned
	
	@Column(name = "booking_date",columnDefinition = "DATE",nullable = false)
	private LocalDate bookingDate;	//date of booking
	
	@Column(name = "start_date",columnDefinition = "DATE",nullable = false)
	private LocalDate startDate;	//stay start date 
	
	@Column(name = "end_date",columnDefinition = "DATE",nullable = false)
	private LocalDate endDate;		//stay end date
	
	@Column(name = "total_amount",nullable = false)
	private double totalAmount;  
	
	@Column(nullable = false)
	private String status; //ACTIVE/ COMPLTED / CANCELLED

	//Constructor
	public Booking(Long id, User user, Room room, LocalDate bookingDate, LocalDate startDate, LocalDate endDate,
			double totalAmount, String status) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.bookingDate = bookingDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	//Getters-Setters

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Room getRoom() {
		return room;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
