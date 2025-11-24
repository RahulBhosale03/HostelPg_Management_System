package com.hostel.hostel_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.hostel_management.model.Payment;
import com.hostel.hostel_management.repository.PaymentRepository;
import com.hostel.hostel_management.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Optional<Payment> getPaymentById(Long id) {
		return paymentRepository.findById(id);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment updatePayment(Long id, Payment payment) {
		Optional<Payment> existingPayment = paymentRepository.findById(id);
		if(existingPayment.isPresent()) {
			Payment updatedPayment = existingPayment.get();
            updatedPayment.setBooking(payment.getBooking());
            updatedPayment.setAmountPaid(payment.getAmountPaid());
            updatedPayment.setPaymentDate(payment.getPaymentDate());
            updatedPayment.setPaymentMode(payment.getPaymentMode());
            updatedPayment.setTransactionId(payment.getTransactionId());
            updatedPayment.setStatus(payment.getStatus());
            return paymentRepository.save(updatedPayment);
		}else {
		return null;
		}
	}

	@Override
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}

}
