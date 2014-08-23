package com.suthar.rentel.domain;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.MovieType;
import com.suthar.rentel.domain.model.Rental;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class CustomerTest {

    private static final Set<Rental> EMPTY_RENTALS = Collections.emptySet();

    private Customer customer;
    private Set<Rental> mixedRentals;

    @Before
    public void setUp() {
        customer = new Customer("John Smith");

        final Movie montyPython = new Movie("Monty Python and the Holy Grail", MovieType.NEW);
        final Movie ran = new Movie("Ran", MovieType.NEW);
        final Movie laConfidential = new Movie("LA Confidential", MovieType.OLD);
        final Movie starTrek = new Movie("Star Trek 13.2", MovieType.OLD);
        final Movie WallaceAndGromit = new Movie("Wallace and Gromit", MovieType.CLASSICAL);

        mixedRentals = new LinkedHashSet<Rental>();
        LocalDateTime rentedOn = new LocalDateTime();
        mixedRentals.add(new Rental(customer, montyPython, Period.days(3), rentedOn));
        mixedRentals.add(new Rental(customer, ran, Period.days(1), rentedOn));
        mixedRentals.add(new Rental(customer, laConfidential, Period.days(2), rentedOn));
        mixedRentals.add(new Rental(customer, starTrek, Period.days(1), rentedOn));
        mixedRentals.add(new Rental(customer, WallaceAndGromit, Period.days(6), rentedOn));
    }

    @Test
    public void testEmpty() throws Exception {
        String noRentalsStatement =
                "Rental Record for John Smith\n"
                        + "Amount charged is $0.0\n"
                        + "Total Reward Points is 0.0";
        assertEquals(noRentalsStatement, customer.statement(EMPTY_RENTALS));
    }

    @Test
    public void testCustomer() throws Exception {
        String expected =
                "Rental Record for John Smith\n"
                        + "  Monty Python and the Holy Grail  -  $2.5\n"
                        + "  Ran  -  $2.0\n"
                        + "  LA Confidential  -  $2.0\n"
                        + "  Star Trek 13.2  -  $1.0\n"
                        + "  Wallace and Gromit  -  $3.0\n"
                        + "Amount charged is $10.5\n"
                        + "Total Reward Points is 21.5";
        assertEquals(expected, customer.statement(mixedRentals));
    }

}
