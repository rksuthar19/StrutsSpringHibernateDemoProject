package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Transaction;
import com.suthar.rentel.domain.specification.TransactionsForCustomerSpecification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedTransactionRepository extends SetBasedRepository<Transaction> implements TransactionRepository {

    public SetBasedTransactionRepository() {
        super();
    }

    @Override
    public Collection<Transaction> transactionsBy(Customer customer) {
        return selectSatisfying(new TransactionsForCustomerSpecification(customer), Transaction.TX_COMPARE_DATE_TIME);
    }
}
