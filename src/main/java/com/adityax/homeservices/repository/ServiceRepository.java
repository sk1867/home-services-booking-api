package com.adityax.homeservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adityax.homeservices.entity.HomeService;

public interface ServiceRepository
        extends JpaRepository<HomeService, Long> {

    List<HomeService> findByNameContainingIgnoreCase(String name);
}
