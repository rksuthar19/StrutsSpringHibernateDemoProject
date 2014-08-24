package com.suthar.rentel.domain.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @OneToOne
    private Movie movie;
    @OneToOne
    private Customer customer;
    @Column
    private LocalDateTime rentedOn;
    @Column
    @Type(type="org.joda.time.Period")
    private Period period;
    @Column
    public boolean returnStatus;

    public Rental() {
    }

    public Rental(Customer customer, Movie movie, Period period, LocalDateTime rentedOn) {
        this.movie = movie;
        this.customer = customer;
        this.period = period;
        this.rentedOn = rentedOn;
        this.returnStatus = false;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Period getPeriod() {
        return period;
    }

    public LocalDateTime getRentedOn() {
        return rentedOn;
    }

    public LocalDateTime getEndDate() {
        return rentedOn.plus(period);
    }

    public boolean isReturned() {
        return returnStatus;
    }

    public void setReturn() {
        this.returnStatus = true;
    }
}