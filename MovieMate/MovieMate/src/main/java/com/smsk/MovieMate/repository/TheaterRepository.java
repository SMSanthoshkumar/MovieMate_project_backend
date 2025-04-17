package com.smsk.MovieMate.repository;

import com.smsk.MovieMate.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    // Additional query methods if needed
}
