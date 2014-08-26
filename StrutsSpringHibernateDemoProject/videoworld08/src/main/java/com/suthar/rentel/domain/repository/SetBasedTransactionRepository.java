package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Transaction;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.specification.TransactionsForCustomerSpecification;
import com.suthar.rentel.domain.util.NullObjectAddedException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedTransactionRepository implements TransactionRepository {

    public SetBasedTransactionRepository() {
        super();
    }

    @Override
    public void add(Transaction entity) throws NullObjectAddedException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void add(Collection<Transaction> entities) throws NullObjectAddedException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Transaction> selectAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Transaction> selectAll(Comparator<Transaction> comparator) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Transaction> selectSatisfying(Specification<Transaction> specification, Comparator<Transaction> comparator) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Transaction> transactionsBy(Customer customer) {
        return selectSatisfying(new TransactionsForCustomerSpecification(customer), Transaction.TX_COMPARE_DATE_TIME);
    }
}
