package com.suthar.rentel.domain.specification;


import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Transaction;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class TransactionsForCustomerSpecification implements Specification<Transaction> {
    private final Customer customer;

    public TransactionsForCustomerSpecification(final Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean isSatisfiedBy(final Transaction transaction) {
        return customer.equals(transaction.getCustomer());
    }

}
