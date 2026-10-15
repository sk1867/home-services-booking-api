package com.adityax.homeservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adityax.homeservices.dto.BookingRequest;
import com.adityax.homeservices.dto.BookingResponse;
import com.adityax.homeservices.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a new booking
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse createBooking(
            @Valid @RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    // Get all bookings
    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}
