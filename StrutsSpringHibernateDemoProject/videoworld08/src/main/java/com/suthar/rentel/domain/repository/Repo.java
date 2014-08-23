package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.MovieType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class Repo {
    static final Customer customer1 = new Customer("James Madison");
    static final Customer customer2 = new Customer("Zackery Taylor");
    static final Customer customer3 = new Customer("Benjamin Harrison");
    static final List<Customer> customerList = Arrays.asList(customer1, customer2, customer3);

    static final Movie avatar = new Movie("Avatar", MovieType.NEW);
    static final Movie upInTheAir = new Movie("Up In The Air", MovieType.CLASSICAL);
    static final Movie findingNemo = new Movie("Finding Nemo", MovieType.OLD);
    static final Collection<Movie> movieList = Arrays.asList(avatar, upInTheAir, findingNemo);

}
