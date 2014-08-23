package com.suthar.rentel.domain.specification;


import com.suthar.rentel.domain.model.Customer;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class CustomerWithNameSpecification implements Specification<Customer> {

    private final String customerName;

    public CustomerWithNameSpecification(final String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean isSatisfiedBy(final Customer customer) {
        return customer.getName().equals(customerName);
    }


}
