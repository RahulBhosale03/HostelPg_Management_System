package com.hostel.hostel_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.hostel_management.model.Booking;
import com.hostel.hostel_management.repository.BookingRepository;
import com.hostel.hostel_management.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Optional<Booking> getBookingById(Long id) {
		return bookingRepository.findById(id);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking updateBooking(Long id, Booking booking) {
		Optional<Booking> existingBooking = bookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            Booking updatedBooking = existingBooking.get();
            updatedBooking.setUser(booking.getUser());
            updatedBooking.setRoom(booking.getRoom());
            updatedBooking.setBookingDate(booking.getBookingDate());
            updatedBooking.setStartDate(booking.getStartDate());
            updatedBooking.setEndDate(booking.getEndDate());
            updatedBooking.setTotalAmount(booking.getTotalAmount());
            updatedBooking.setStatus(booking.getStatus());
            return bookingRepository.save(updatedBooking);
        }else {
		return null;
        }
	}

	@Override
	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);	
	}
}
