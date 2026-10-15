package com.adityax.homeservices.service;

import java.util.List;
import com.adityax.homeservices.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import com.adityax.homeservices.dto.ServiceResponse;
import com.adityax.homeservices.entity.HomeService;
import com.adityax.homeservices.repository.ServiceRepository;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceResponse> getAllServices() {
        return serviceRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    public ServiceResponse getServiceById(Long id) {
        HomeService service = serviceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service not found with ID: " + id));

        return convertToResponse(service);
    }

    public List<ServiceResponse> searchServices(String name) {
        return serviceRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private ServiceResponse convertToResponse(HomeService service) {
        return new ServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getStartingPrice(),
                service.getRating()
        );
    }
}
