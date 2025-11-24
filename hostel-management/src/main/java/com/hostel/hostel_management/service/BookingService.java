package com.hostel.hostel_management.service;

import java.util.List;
import java.util.Optional;

import com.hostel.hostel_management.model.Booking;

public interface BookingService {
	Booking saveBooking(Booking booking);
	
    Optional<Booking> getBookingById(Long id);
    
    List<Booking> getAllBookings();
    
    Booking updateBooking(Long id, Booking booking);
    
    void deleteBooking(Long id);
}
