
package com.adityax.homeservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adityax.homeservices.dto.ServiceResponse;
import com.adityax.homeservices.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // Get all home services
    @GetMapping
    public List<ServiceResponse> getAllServices() {
        return serviceService.getAllServices();
    }

    // Get service by ID
    @GetMapping("/{id}")
    public ServiceResponse getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    // Search services by name
    @GetMapping("/search")
    public List<ServiceResponse> searchServices(
            @RequestParam String name) {
        return serviceService.searchServices(name);
    }
}
