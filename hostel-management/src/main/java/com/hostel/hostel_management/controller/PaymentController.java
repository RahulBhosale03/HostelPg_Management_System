package com.hostel.hostel_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.hostel_management.model.Payment;
import com.hostel.hostel_management.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.savePayment(payment));
    }	
	
	@GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        Payment updated = paymentService.updatePayment(id, payment);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
	        paymentService.deletePayment(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 

}
