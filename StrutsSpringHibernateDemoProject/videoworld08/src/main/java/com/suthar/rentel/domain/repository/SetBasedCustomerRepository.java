package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.service.CustomerService;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedCustomerRepository implements CustomerRepository {
    @Autowired
    private CustomerService customerService;

    public void add(final Customer customer) throws NullObjectAddedException {
        if (customer == null) {
            throw new NullObjectAddedException();
        }
        customerService.saveCustomer(customer);
    }

    public void add(final Collection<Customer> customers) throws NullObjectAddedException {
        if (customers == null) {
            throw new IllegalArgumentException();
        }
        for (final Customer customer : customers) {
            if (customer == null) {
                throw new NullObjectAddedException();
            }
            customerService.saveCustomer(customer);
        }
    }

    public List<Customer> selectAll() {
        return customerService.getAllCustomers();
    }

    public List<Customer> selectAll(final Comparator<Customer> comparator) {
        final List<Customer> result = customerService.getAllCustomers();
        Collections.sort(result, comparator);
        return result;
    }

    public List<Customer> selectSatisfying(final Specification<Customer> specification) {
        return selectSatisfyingIntoCollection(specification);
    }

    public List<Customer> selectSatisfying(final Specification<Customer> specification, final Comparator<Customer> comparator) {
        final List<Customer> result = selectSatisfyingIntoCollection(specification);
        Collections.sort(result, comparator);
        return result;
    }

    public Customer selectUnique(final Specification<Customer> specification) throws NonUniqueObjectSelectedException {
        final List<Customer> results = selectSatisfyingIntoCollection(specification);
        if (results.size() == 1) {
            return results.get(0);
        } else if (!results.isEmpty()) {
            throw new NonUniqueObjectSelectedException();
        }
        return null;
    }

    private List<Customer> selectSatisfyingIntoCollection(final Specification<Customer> specification) {
        List<Customer> target = new ArrayList<Customer>();
        for (Customer object : customerService.getAllCustomers()) {
            if (specification.isSatisfiedBy(object)) {
                target.add(object);
            }
        }
        return target;
    }
}
