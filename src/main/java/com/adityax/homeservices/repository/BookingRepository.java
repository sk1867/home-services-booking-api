package com.adityax.homeservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adityax.homeservices.entity.Booking;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {
}
