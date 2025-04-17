package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Screen;
import com.smsk.MovieMate.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    @Autowired
    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }
}
