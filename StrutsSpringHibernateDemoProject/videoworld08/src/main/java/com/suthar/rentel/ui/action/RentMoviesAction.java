package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.model.Transaction;
import com.suthar.rentel.domain.repository.MovieRepository;
import com.suthar.rentel.domain.repository.RentalRepository;
import com.suthar.rentel.domain.repository.TransactionRepository;
import com.suthar.rentel.ui.interceptor.CustomerAware;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class RentMoviesAction extends ActionSupport implements CustomerAware {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    private Customer customer;
    private String statement;
    private String[] movieNames;
    private int rentalDuration;

    @Override
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public void setMovieNames(final String[] movieNames) {
        this.movieNames = movieNames;
    }

    public void setRentalDuration(final int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public String getStatement() {
        return statement;
    }

    @Override
    public String execute() throws Exception {
        final Set<Movie> movies = movieRepository.withTitles(movieNames);
        LocalDateTime now = new LocalDateTime();
        final Period rentalPeriod = Period.days(rentalDuration);

        final Set<Rental> rentals = new LinkedHashSet<Rental>();
        for (final Movie movie : movies) {
            final Rental rental = new Rental(customer, movie, rentalPeriod, now);
            rentals.add(rental);
        }

        rentalRepository.add(rentals);
        final Transaction transaction = new Transaction(now, customer, rentals);
        transactionRepository.add(transaction);

        statement = customer.statement(transaction.getRentals());
        return SUCCESS;
    }

}
