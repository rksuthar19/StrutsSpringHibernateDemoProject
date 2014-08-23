package com.suthar.rentel.domain.model;

import org.joda.time.LocalDateTime;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class Transaction {
    private final LocalDateTime dateTime;
    private final Customer customer;
    private final Set<Rental> rentals;

    public Transaction(final LocalDateTime dateTime, final Customer customer, final Set<Rental> rentals) {
        this.dateTime = dateTime;
        for (final Rental rental : rentals) {
            if (!rental.getCustomer().equals(customer)) {
                throw new IllegalArgumentException("Rentals must be for the same customer");
            }
        }
        this.customer = customer;
        this.rentals = Collections.unmodifiableSet(new HashSet<Rental>(rentals));
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public static Comparator<Transaction> TX_COMPARE_DATE_TIME = new Comparator<Transaction>() {

        @Override
        public int compare(final Transaction transaction1, final Transaction transaction2) {
            return transaction1.getDateTime().compareTo(transaction2.getDateTime());
        }
    };
}
