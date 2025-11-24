package com.hostel.hostel_management.service;

import java.util.List;
import java.util.Optional;
import com.hostel.hostel_management.model.Payment;

public interface PaymentService {
	 Payment savePayment(Payment payment);
	    Optional<Payment> getPaymentById(Long id);
	    List<Payment> getAllPayments();
	    Payment updatePayment(Long id, Payment payment);
	    void deletePayment(Long id);
}
