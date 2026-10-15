package com.adityax.homeservices.dto;

import java.time.LocalDate;

import com.adityax.homeservices.entity.BookingStatus;

public class BookingResponse {

    private Long id;
    private Long serviceId;
    private String serviceName;
    private String customerName;
    private String phone;
    private String address;
    private LocalDate date;
    private String timeSlot;
    private BookingStatus status;

    public BookingResponse() {
    }

    public BookingResponse(Long id, Long serviceId, String serviceName,
                           String customerName, String phone, String address,
                           LocalDate date, String timeSlot, BookingStatus status) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
