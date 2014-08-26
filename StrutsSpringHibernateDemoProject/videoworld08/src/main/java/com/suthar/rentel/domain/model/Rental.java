package com.suthar.rentel.domain.model;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import javax.persistence.*;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Movie movie;
    @OneToOne
    private Customer customer;
    @Column
    private LocalDateTime rentedOn;
    @Column
    private int rentedForDays;
    @Column
    public boolean returnStatus;

    public Rental() {
    }

    public Rental(Customer customer, Movie movie, int rentedForDays, LocalDateTime rentedOn) {
        this.movie = movie;
        this.customer = customer;
        this.rentedForDays = rentedForDays;
        this.rentedOn = rentedOn;
        this.returnStatus = false;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getRentedForDays() {
        return rentedForDays;
    }

    public LocalDateTime getRentedOn() {
        return rentedOn;
    }

    public LocalDateTime getEndDate() {
        return rentedOn.plus(Period.days(rentedForDays));
    }

    public boolean isReturned() {
        return returnStatus;
    }

    public void setReturn() {
        this.returnStatus = true;
    }
}