package com.smsk.MovieMate.controller;

import com.smsk.MovieMate.model.Seat;
import com.smsk.MovieMate.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/available")
    public ResponseEntity<List<Seat>> getAvailableSeats(@RequestParam Long screenId) {
        List<Seat> seats = seatService.getAvailableSeats(screenId);
        return ResponseEntity.ok(seats);
    }

    @PostMapping("/lock/{seatId}")
    public ResponseEntity<String> lockSeat(@PathVariable Long seatId) {
        boolean locked = seatService.lockSeat(seatId);
        if (locked) {
            return ResponseEntity.ok("Seat locked successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat already locked/booked");
        }
    }

    @PostMapping("/release/{seatId}")
    public ResponseEntity<String> releaseSeat(@PathVariable Long seatId) {
        seatService.releaseSeat(seatId);
        return ResponseEntity.ok("Seat released successfully");
    }
}
