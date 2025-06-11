// BookingService.java
package com.example.demo.services;

import com.example.demo.entities.Booking;
import com.example.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking create(Booking booking) { return bookingRepository.save(booking); }
    //public List<Booking> getByGuest(String guestName) { return bookingRepository.findByUser(guestName); }
}