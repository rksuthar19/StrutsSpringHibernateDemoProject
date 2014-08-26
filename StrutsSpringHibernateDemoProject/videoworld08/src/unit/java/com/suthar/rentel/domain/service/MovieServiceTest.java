package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.MovieType;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CustomerServiceTest-context.xml")
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    public void testSaveCustomer() {
        Movie avatar = new Movie("Avatar", MovieType.NEW);
        avatar = movieService.saveMovie(avatar);
        Movie savedMovie = movieService.getMovie(avatar.getId());
        Assert.assertEquals("Avatar", savedMovie.getTitle());
    }

    @Test
    public void setUpMovies() {
        Movie avatar = new Movie("Avatar", MovieType.NEW);
        Movie upInTheAir = new Movie("Up In The Air", MovieType.CLASSICAL);
        Movie findingNemo = new Movie("Finding Nemo", MovieType.OLD);
        movieService.saveMovie(avatar);
        movieService.saveMovie(upInTheAir);
        movieService.saveMovie(findingNemo);
    }
}
