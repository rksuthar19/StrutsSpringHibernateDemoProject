package com.suthar.rentel.domain.specification;


import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Rental;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class RentalForCustomerSpecification implements Specification<Rental> {

    private final Customer customer;

    public RentalForCustomerSpecification(final Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean isSatisfiedBy(final Rental rental) {
        return customer.equals(rental.getCustomer());
    }

}
