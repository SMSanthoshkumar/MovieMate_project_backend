package com.smsk.MovieMate.repository;

import  com.smsk.MovieMate.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    // Additional queries if needed
}
