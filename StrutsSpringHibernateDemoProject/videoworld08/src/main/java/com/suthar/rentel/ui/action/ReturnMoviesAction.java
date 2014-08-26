package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.repository.MovieRepository;
import com.suthar.rentel.domain.repository.RentalRepository;
import com.suthar.rentel.ui.interceptor.CustomerAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class ReturnMoviesAction extends ActionSupport implements CustomerAware {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RentalRepository rentalRepository;

    private Customer customer;
    private String[] movieNames;

    @Override
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setMovieNames(final String[] movieNames) {
        this.movieNames = movieNames;
    }

    public Collection<Rental> getRentals() {
        return rentalRepository.selectAll();
    }

    @Override
    public String execute() throws Exception {
        final List<Movie> movies = movieRepository.withTitles(movieNames);
        if (movies.iterator().hasNext()) {
            Rental rentalToReturn = rentalRepository.findRental(movies.iterator().next());
            rentalToReturn.setReturn();
            return SUCCESS;
        }
        return SUCCESS; //toDO
    }
}
