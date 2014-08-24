package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.service.CustomerService;
import com.suthar.rentel.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedCustomerRepository extends SetBasedRepository<Customer> implements CustomerRepository {
/*    @Autowired
    CustomerService customerService;
    public SetBasedCustomerRepository() {
        super(Repo.customerList);
    }*/
}
