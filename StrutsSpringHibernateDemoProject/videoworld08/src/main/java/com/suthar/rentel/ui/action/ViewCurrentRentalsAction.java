package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.repository.RentalRepository;
import com.suthar.rentel.ui.interceptor.CustomerAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class ViewCurrentRentalsAction extends ActionSupport implements CustomerAware {

    @Autowired
    private RentalRepository rentalRepository;

    private Collection<Rental> rentals;
    private Customer customer;

    @Override
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Collection<Rental> getRentals() {
        return rentals;
    }

    @Override
    public String execute() throws Exception {
        rentals = rentalRepository.currentRentalsFor(customer);

        return SUCCESS;
    }

}
