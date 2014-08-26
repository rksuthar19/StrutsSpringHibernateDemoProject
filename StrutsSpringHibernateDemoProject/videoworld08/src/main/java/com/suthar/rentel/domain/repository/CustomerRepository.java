package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public interface CustomerRepository {
    void add(Customer entity) throws NullObjectAddedException;

    void add(Collection<Customer> entities) throws NullObjectAddedException;

    List<Customer> selectAll();

    List<Customer> selectAll(Comparator<Customer> comparator);

    List<Customer> selectSatisfying(Specification<Customer> specification);

    List<Customer> selectSatisfying(Specification<Customer> specification, Comparator<Customer> comparator);

    Customer selectUnique(Specification<Customer> specification) throws NonUniqueObjectSelectedException;
}