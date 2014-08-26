package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class ViewAdminAction extends ActionSupport {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getUsers() {
        return customerRepository.selectAll();
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
