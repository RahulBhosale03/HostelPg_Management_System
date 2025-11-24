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
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "booking_id")
	private Booking booking; // One booking can have many payments
	
	@Column(name = "amount_paid",nullable = false)
	private double amountPaid;
	
	@Column(name = "payment_date",columnDefinition = "DATE",nullable = false)
	private LocalDate paymentDate; // CASH / UPI / CARD / NETBANKING
	
	@Column(name = "payment_mode", nullable = false)
	private String paymentMode;
	
	@Column(name = "transaction_id", unique = true)
	private String transactionId;
	
	@Column(nullable = false)
	private String status;  // SUCCESS / FAILED / PENDING
	
	
	//Constructor

	public Payment(Long id, Booking booking, double amountPaid, LocalDate paymentDate, String paymentMode,
			String transactionId, String status) {
		super();
		this.id = id;
		this.booking = booking;
		this.amountPaid = amountPaid;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.transactionId = transactionId;
		this.status = status;
	}
	
	//Getter-Setter

	public Long getId() {
		return id;
	}

	public Booking getBooking() {
		return booking;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
