package com.smsk.MovieMate.controller;

import com.smsk.MovieMate.model.Booking;
import com.smsk.MovieMate.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> bookSeats(@RequestParam Long userId,
                                       @RequestParam Long showId,
                                       @RequestBody List<Long> seatIds) {
        try {
            Booking booking = bookingService.bookSeats(userId, showId, seatIds);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }
}
