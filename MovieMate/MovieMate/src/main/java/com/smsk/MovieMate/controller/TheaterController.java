package com.smsk.MovieMate.controller;

import  com.smsk.MovieMate.model.Theater;
import com.smsk.MovieMate.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters() {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @PostMapping
    public ResponseEntity<?> addTheater(@RequestBody Theater theater) {
        try {
            Theater savedTheater = theaterService.addTheater(theater);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTheater);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
