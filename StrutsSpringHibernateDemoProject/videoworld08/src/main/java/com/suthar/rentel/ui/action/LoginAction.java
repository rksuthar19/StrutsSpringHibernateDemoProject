package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.repository.CustomerRepository;
import com.suthar.rentel.domain.specification.CustomerWithNameSpecification;
import com.suthar.rentel.domain.specification.CustomersOrderedByNameComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component()
public class LoginAction extends ActionSupport {

    @Autowired
    private CustomerRepository repository;

    private String customerName;
    private Customer loggedInCustomer;

    public void setCustomerName(final String customer) {
        this.customerName = customer;
    }

    public Set<Customer> getCustomers() {
        return repository.selectAll(new CustomersOrderedByNameComparator());
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    @Override
    public String execute() throws Exception {
        if (customerName == null) {
            return LOGIN;
        }

        loggedInCustomer = repository.selectUnique(new CustomerWithNameSpecification(customerName));
        if (loggedInCustomer == null) {
            return LOGIN;
        }

        return SUCCESS;
    }
}
