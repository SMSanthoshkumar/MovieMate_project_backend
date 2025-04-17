package com.smsk.MovieMate.controller;

import com.smsk.MovieMate.model.Show;
import com.smsk.MovieMate.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShowtimes() {
        return ResponseEntity.ok(showtimeService.getAllShowtimes());
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<Show>> getShowtimesByMovie(@RequestParam Long movieId) {
        return ResponseEntity.ok(showtimeService.getShowtimesByMovie(movieId));
    }

    @GetMapping("/by-theater")
    public ResponseEntity<List<Show>> getShowtimesByTheater(@RequestParam Long theaterId) {
        return ResponseEntity.ok(showtimeService.getShowtimesByTheater(theaterId));
    }

    @PostMapping
    public ResponseEntity<?> addShowtime(@RequestBody Show show) {
        try {
            Show savedShow = showtimeService.addShowtime(show);
            return ResponseEntity.status(201).body(savedShow);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
