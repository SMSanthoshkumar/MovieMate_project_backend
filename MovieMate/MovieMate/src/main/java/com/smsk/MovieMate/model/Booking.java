package com.smsk.MovieMate.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user who booked
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // The show being booked
    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    // Booked seats (many-to-many, as a booking may include multiple seats)
    @ManyToMany
    @JoinTable(
            name = "booking_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

    private String status; // e.g., CONFIRMED, CANCELLED
    private LocalDateTime bookingTime;
    private String qrCodeUrl; // URL for e-ticket QR code

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    public Booking(){

    }

    public Booking(Long id, User user, Show show, List<Seat> seats, String status, LocalDateTime bookingTime, String qrCodeUrl, Payment payment) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = status;
        this.bookingTime = bookingTime;
        this.qrCodeUrl = qrCodeUrl;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
