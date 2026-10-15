package com.adityax.homeservices.service;

import java.util.List;
import com.adityax.homeservices.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adityax.homeservices.dto.BookingRequest;
import com.adityax.homeservices.dto.BookingResponse;
import com.adityax.homeservices.entity.Booking;
import com.adityax.homeservices.entity.HomeService;
import com.adityax.homeservices.repository.BookingRepository;
import com.adityax.homeservices.repository.ServiceRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ServiceRepository serviceRepository;

    public BookingService(
            BookingRepository bookingRepository,
            ServiceRepository serviceRepository) {
        this.bookingRepository = bookingRepository;
        this.serviceRepository = serviceRepository;
    }

    @Transactional
    public BookingResponse createBooking(BookingRequest request) {

    	HomeService homeService = serviceRepository.findById(request.getServiceId())
    	        .orElseThrow(() -> new ResourceNotFoundException(
    	                "Service not found with ID: " + request.getServiceId()));
    	
        Booking booking = new Booking();
        booking.setService(homeService);
        booking.setName(request.getCustomerName());
        booking.setPhone(request.getPhone());
        booking.setAddress(request.getAddress());
        booking.setDate(request.getDate());
        booking.setTimeSlot(request.getTimeSlot());

        Booking savedBooking = bookingRepository.save(booking);

        return convertToResponse(savedBooking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking not found with ID: " + id));

        return convertToResponse(booking);
    }

    private BookingResponse convertToResponse(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getService().getId(),
                booking.getService().getName(),
                booking.getName(),
                booking.getPhone(),
                booking.getAddress(),
                booking.getDate(),
                booking.getTimeSlot(),
                booking.getStatus()
        );
    }
}
