package com.suthar.rentel.domain.model;

import javax.persistence.*;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column
    private MovieType type;

    public Movie() {
    }

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }

    public long getId() {
        return id;
    }
}
