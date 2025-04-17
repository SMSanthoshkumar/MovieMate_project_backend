package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Movie;
import com.smsk.MovieMate.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        // Additional validations can be added here
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByLocation(Long locationId) {
        return movieRepository.findByLocationId(locationId);
    }
}
