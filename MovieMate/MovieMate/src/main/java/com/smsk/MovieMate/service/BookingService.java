package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Booking;
import com.smsk.MovieMate.model.Seat;
import com.smsk.MovieMate.repository.BookingRepository;
import com.smsk.MovieMate.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    public synchronized Booking bookSeats(Long userId, Long showId, List<Long> seatIds) {
        // Fetch and lock seats
        List<Seat> seats = seatRepository.findAllById(seatIds);
        for (Seat seat : seats) {
            if (seat.isBooked()) {
                throw new RuntimeException("Seat " + seat.getSeatNumber() + " is already booked.");
            }
            seat.setBooked(true);
            seatRepository.save(seat);
        }
        Booking booking = new Booking();
        // Set user and show on the booking
        // (Assume you have methods to fetch User and Show objects by their IDs)
        // booking.setUser(fetchedUser);
        // booking.setShow(fetchedShow);
        booking.setSeats(seats);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
