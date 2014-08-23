package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedCustomerRepository extends SetBasedRepository<Customer> implements CustomerRepository {
    public SetBasedCustomerRepository() {
        super(Repo.customerList);
    }
}
