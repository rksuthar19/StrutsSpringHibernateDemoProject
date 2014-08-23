package com.suthar.rentel.ui.action;

import com.suthar.rentel.domain.model.*;
import com.suthar.rentel.domain.repository.MovieRepository;
import com.suthar.rentel.domain.repository.RentalRepository;
import com.suthar.rentel.domain.repository.TransactionRepository;
import org.hamcrest.Matcher;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class RentMoviesActionTest {
    private static final Movie THE_GODFATHER = new Movie("The Godfather", MovieType.NEW);
    private static final Movie PULP_FICTION = new Movie("Pulp Fiction", MovieType.NEW);
    private static final Movie FINDING_NEMO = new Movie("Finding Nemo", MovieType.NEW);
    private RentMoviesAction rentMoviesAction;
    private Customer customer;


    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepositoryMock = Mockito.mock(MovieRepository.class);
        RentalRepository rentalRepositoryMock = Mockito.mock(RentalRepository.class);
        TransactionRepository transactionRepositoryMock = Mockito.mock(TransactionRepository.class);
        rentMoviesAction = new RentMoviesAction();
        Whitebox.setInternalState(rentMoviesAction, "movieRepository", movieRepositoryMock);
        Whitebox.setInternalState(rentMoviesAction, "rentalRepository", rentalRepositoryMock);
        Whitebox.setInternalState(rentMoviesAction, "transactionRepository", transactionRepositoryMock);
        customer = mock(Customer.class);
        rentMoviesAction.setCustomer(customer);
    }

    @Test
    @Ignore //TODO fix test
    public void shouldCreateRentalForEachMovie() throws Exception {
        rentMoviesAction.setMovieNames(new String[]{THE_GODFATHER.getTitle(), PULP_FICTION.getTitle()});
        final int days = 1;
        rentMoviesAction.setRentalDuration(days);
        rentMoviesAction.execute();
        RentalRepository rentalRepositoryMock = Mockito.mock(RentalRepository.class);
        verify(rentalRepositoryMock).add(argThat(isRentalsForDurationAndOf(days, THE_GODFATHER, PULP_FICTION)));
    }

    @Test
    @Ignore //TODO fix test
    public void shouldCreateTransactionForAllRentals() throws Exception {
        rentMoviesAction.setMovieNames(new String[]{THE_GODFATHER.getTitle(), FINDING_NEMO.getTitle()});
        final int days = 6;
        rentMoviesAction.setRentalDuration(days);
        rentMoviesAction.execute();
        TransactionRepository transactionRepositoryMock = Mockito.mock(TransactionRepository.class);
        verify(transactionRepositoryMock).add(
                argThat(isTransactionWithRentalsForDurationAndOf(days, THE_GODFATHER, FINDING_NEMO)));
    }

    @SuppressWarnings("unchecked")
    @Test
    @Ignore //TODO fix test
    public void shouldRetrieveCustomerStatement() throws Exception {
        rentMoviesAction.setMovieNames(new String[]{THE_GODFATHER.getTitle(), PULP_FICTION.getTitle()});
        final int days = 3;
        rentMoviesAction.setRentalDuration(days);

        final String statement = "my statement";
        when(customer.statement((Set<Rental>) anyObject())).thenReturn(statement);
        rentMoviesAction.execute();

        verify(customer).statement(argThat(isRentalsForDurationAndOf(days, THE_GODFATHER, PULP_FICTION)));
        assertEquals(statement, rentMoviesAction.getStatement());
    }

    @SuppressWarnings("unchecked")
    private Matcher<Set<Rental>> isRentalsForDurationAndOf(final int days, final Movie firstMovie,
                                                           final Movie... movies) {
        final Period period = Period.days(days);

        final List rentalMatchers = new ArrayList();
        rentalMatchers.add(hasSize(movies.length + 1));
        rentalMatchers.add(hasItem(allOf(hasProperty("period", equalTo(period)), hasProperty("movie",
                sameInstance(firstMovie)))));
        for (final Movie movie : movies) {
            rentalMatchers.add(hasItem(allOf(hasProperty("period", equalTo(period)), hasProperty("movie",
                    sameInstance(movie)))));
        }

        return allOf((Iterable) rentalMatchers);
    }

    private Matcher<Transaction> isTransactionWithRentalsForDurationAndOf(final int days, final Movie firstMovie,
                                                                          final Movie... movies) {
        return hasProperty("rentals", isRentalsForDurationAndOf(days, firstMovie, movies));
    }

}
