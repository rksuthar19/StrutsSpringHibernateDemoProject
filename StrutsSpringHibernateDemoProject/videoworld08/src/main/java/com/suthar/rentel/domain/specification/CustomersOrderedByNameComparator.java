package com.suthar.rentel.domain.specification;


import com.suthar.rentel.domain.model.Customer;

import java.util.Comparator;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class CustomersOrderedByNameComparator implements Comparator<Customer> {

    @Override
    public int compare(final Customer customer1, final Customer customer2) {
        return (customer1 == customer2) ? 0 : customer1.getName().compareTo(customer2.getName());
    }


}
