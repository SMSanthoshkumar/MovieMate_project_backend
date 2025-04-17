package com.smsk.MovieMate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;
    private String rowLabel; // e.g., A, B, C...

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType; // NORMAL, PREMIUM, VIP, RECLINER, etc.

    @Column(nullable = false)
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    public Seat(){

    }

    public Seat(Long id, String seatNumber, String rowLabel, SeatType seatType, boolean isBooked, Screen screen) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.rowLabel = rowLabel;
        this.seatType = seatType;
        this.isBooked = isBooked;
        this.screen = screen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRowLabel() {
        return rowLabel;
    }

    public void setRowLabel(String rowLabel) {
        this.rowLabel = rowLabel;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
