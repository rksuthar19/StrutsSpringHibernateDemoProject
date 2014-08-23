package com.suthar.rentel.domain.model;

import com.suthar.rentel.domain.strategy.ChargeStrategy;
import com.suthar.rentel.domain.strategy.RewardPointsStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    private Long id;
    @Column
    private String name;

    public Customer() {
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
            final Integer rentalDays = rental.getPeriod().getDays();

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
