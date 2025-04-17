package com.smsk.MovieMate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String screenNumber;
    private int totalSeats;
    private String audioType;   // Dolby, Atmos, etc.
    private String resolution;  // 2K, 4K, etc.

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Seat> seats;

    public Screen(){

    }

    public Screen(Long id, String screenNumber, int totalSeats, String audioType, String resolution, Theater theater, List<Seat> seats) {
        this.id = id;
        this.screenNumber = screenNumber;
        this.totalSeats = totalSeats;
        this.audioType = audioType;
        this.resolution = resolution;
        this.theater = theater;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(String screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
