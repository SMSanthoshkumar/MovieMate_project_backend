package com.smsk.MovieMate.repository;

import com.smsk.MovieMate.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);
    List<Show> findByTheaterId(Long theaterId);
}
