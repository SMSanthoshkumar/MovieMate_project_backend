package com.smsk.MovieMate.repository;

import com.smsk.MovieMate.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Retrieve movies available in a specific location via join through show->theater->locations
    @Query("SELECT DISTINCT m FROM Movie m JOIN m.shows s JOIN s.theater t JOIN t.locations l WHERE l.id = :locationId")
    List<Movie> findByLocationId(@Param("locationId") Long locationId);
}
