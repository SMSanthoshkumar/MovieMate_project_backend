package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Show;
import com.smsk.MovieMate.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public List<Show> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public List<Show> getShowtimesByMovie(Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public List<Show> getShowtimesByTheater(Long theaterId) {
        return showtimeRepository.findByTheaterId(theaterId);
    }

    public Show addShowtime(Show show) {
        return showtimeRepository.save(show);
    }
}
