package com.suthar.rentel.domain.model;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class Movie {
    private String title;
    private MovieType type;

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
}
