package com.smsk.MovieMate.controller;

import com.smsk.MovieMate.model.Movie;
import com.smsk.MovieMate.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        try {
            Movie savedMovie = movieService.addMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/by-location")
    public ResponseEntity<List<Movie>> getMoviesByLocation(@RequestParam Long locationId) {
        return ResponseEntity.ok(movieService.getMoviesByLocation(locationId));
    }
}
