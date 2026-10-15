package com.adityax.homeservices;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adityax.homeservices.entity.HomeService;
import com.adityax.homeservices.repository.ServiceRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ServiceRepository serviceRepository;

    public DataInitializer(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void run(String... args) {

        if (serviceRepository.count() > 0) {
            return;
        }

        List<HomeService> services = List.of(
            new HomeService(
                "Home Cleaning",
                "Professional cleaning for your home.",
                new BigDecimal("799.00"),
                new BigDecimal("4.5")
            ),
            new HomeService(
                "Deep Cleaning",
                "Detailed cleaning of floors, kitchens and bathrooms.",
                new BigDecimal("1499.00"),
                new BigDecimal("4.8")
            ),
            new HomeService(
                "Plumbing",
                "Repair leaking taps, pipes and water fittings.",
                new BigDecimal("299.00"),
                new BigDecimal("4.4")
            ),
            new HomeService(
                "Electrician",
                "Electrical repairs, switches and wiring services.",
                new BigDecimal("349.00"),
                new BigDecimal("4.6")
            ),
            new HomeService(
                "AC Repair",
                "Inspection and repair of home air conditioners.",
                new BigDecimal("499.00"),
                new BigDecimal("4.3")
            ),
            new HomeService(
                "Appliance Repair",
                "Repair services for common household appliances.",
                new BigDecimal("399.00"),
                new BigDecimal("4.2")
            ),
            new HomeService(
                "Painting",
                "Interior wall painting and touch-up services.",
                new BigDecimal("2499.00"),
                new BigDecimal("4.7")
            ),
            new HomeService(
                "Pest Control",
                "Pest inspection and treatment for your home.",
                new BigDecimal("899.00"),
                new BigDecimal("4.5")
            )
        );

        serviceRepository.saveAll(services);

        System.out.println("8 home services initialized successfully.");
    }
}
