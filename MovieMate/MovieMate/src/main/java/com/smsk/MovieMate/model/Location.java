package com.smsk.MovieMate.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    // Bidirectional many-to-many: mappedBy must match the field in Theater
    @ManyToMany(mappedBy = "locations", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Theater> theaters;

    public Location(){

    }

    public Location(Long id, String name, List<Theater> theaters) {
        this.id = id;
        this.name = name;
        this.theaters = theaters;
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

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }
}
