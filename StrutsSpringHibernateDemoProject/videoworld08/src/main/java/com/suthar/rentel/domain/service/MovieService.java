package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Service
public class MovieService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Movie getMovie(String id) {
        return entityManager.find(Movie.class, id);
    }

    @Transactional
    public List<Movie> getAllMovies() {
        return (List<Movie>) entityManager.createQuery("from " + Movie.class.toString());
    }

    @Transactional
    public Movie saveCustomer(Movie movie) {
        return entityManager.merge(movie);
    }
}