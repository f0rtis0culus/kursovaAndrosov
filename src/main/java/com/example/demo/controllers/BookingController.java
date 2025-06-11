package com.example.demo.controllers;

import com.example.demo.entities.Booking;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public BookingController(BookingRepository bookingRepository,
                             RoomRepository roomRepository,
                             UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    // Отримати всі бронювання
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Отримати бронювання за ID
    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id);
    }

    // Створити бронювання
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        // Перевірка чи існує користувач і кімната
        if (booking.getUser() == null || booking.getRoom() == null) {
            throw new RuntimeException("User and Room must be specified");
        }
        return bookingRepository.save(booking);
    }

    // Оновити статус оплати
    @PatchMapping("/{id}/pay")
    public Booking markAsPaid(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setPaid(true);
        return bookingRepository.save(booking);
    }

    // Видалити бронювання
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}
