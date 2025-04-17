package com.smsk.MovieMate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "theaters")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // A theater can be associated with one or more locations (if needed)
    @ManyToMany
    @JoinTable(
            name = "theater_locations",
            joinColumns = @JoinColumn(name = "theater_id", columnDefinition = "BIGINT"),
            inverseJoinColumns = @JoinColumn(name = "location_id", columnDefinition = "BIGINT")
    )
    private List<Location> locations;

    @Column(nullable = false)
    private int totalScreens;

    @Column(nullable = false)
    private int seatingCapacity;

    private boolean hasParking;
    private String contactNumber;
    private String website;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Screen> screens;

    public Theater() {
    }

    public Theater(Long id, String name, List<Location> locations, int totalScreens, int seatingCapacity, boolean hasParking, String contactNumber, String website, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.totalScreens = totalScreens;
        this.seatingCapacity = seatingCapacity;
        this.hasParking = hasParking;
        this.contactNumber = contactNumber;
        this.website = website;
        this.screens = screens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
