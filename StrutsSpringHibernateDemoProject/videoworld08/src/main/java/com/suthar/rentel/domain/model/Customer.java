package com.suthar.rentel.domain.model;

import com.suthar.rentel.domain.strategy.ChargeStrategy;
import com.suthar.rentel.domain.strategy.RewardPointsStrategy;

import javax.persistence.*;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String statement(final Set<Rental> newRentals) {
        String result = "Rental Record for " + getName() + "\n";

        double totalAmount = 0;
        double totalRewardPoints = 0;
        for (Rental rental : newRentals) {
            // show figures for this rental
            final int rentalDays = rental.getRentedForDays();

            double charge = ChargeStrategy.getCharge(rental.getMovie().getType(), rentalDays);
            result += "  " + rental.getMovie().getTitle() + "  -  $"
                    + String.valueOf(charge) + "\n";
            totalAmount += charge;
            totalRewardPoints += RewardPointsStrategy.getRewardPoints(rental.getMovie().getType(), rentalDays);
        }

        // add footer lines
        result += "Amount charged is $" + String.valueOf(totalAmount) + "\n";
        result += "Total Reward Points is " + String.valueOf(totalRewardPoints);
        return result;
    }

}
