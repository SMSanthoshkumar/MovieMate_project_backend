package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Seat;
import com.smsk.MovieMate.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAvailableSeats(Long screenId) {
        // Assume that isReserved false means available
        return seatRepository.findByScreenId(screenId).stream()
                .filter(seat -> !seat.isBooked())
                .toList();
    }

    @Transactional
    public synchronized boolean lockSeat(Long seatId) {
        Optional<Seat> seatOpt = seatRepository.findById(seatId);
        if (seatOpt.isPresent() && !seatOpt.get().isBooked()) {
            Seat seat = seatOpt.get();
            seat.setBooked(true);
            seatRepository.save(seat);
            return true;
        }
        return false;
    }

    @Transactional
    public void releaseSeat(Long seatId) {
        Optional<Seat> seatOpt = seatRepository.findById(seatId);
        if (seatOpt.isPresent() && seatOpt.get().isBooked()) {
            Seat seat = seatOpt.get();
            seat.setBooked(false);
            seatRepository.save(seat);
        }
    }
}
