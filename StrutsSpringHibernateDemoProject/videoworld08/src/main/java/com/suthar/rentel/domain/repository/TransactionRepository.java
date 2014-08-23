package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Transaction;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public interface TransactionRepository {
    void add(Transaction entity) throws NullObjectAddedException;

    void add(Collection<Transaction> entities) throws NullObjectAddedException;

    Set<Transaction> selectAll();

    Set<Transaction> selectAll(Comparator<Transaction> comparator);

    Set<Transaction> selectSatisfying(Specification<Transaction> specification);

    Set<Transaction> selectSatisfying(Specification<Transaction> specification, Comparator<Transaction> comparator);

    Transaction selectUnique(Specification<Transaction> specification) throws NonUniqueObjectSelectedException;

    Collection<Transaction> transactionsBy(Customer customer);
}
