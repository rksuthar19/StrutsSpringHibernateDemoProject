package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CustomerServiceTest-context.xml")
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("suthar");
        customer = customerService.saveCustomer(customer);
        Customer savedCustomer = customerService.getCustomer(customer.getId());
        Assert.assertEquals("suthar", savedCustomer.getName());
    }

    @Test
    public void setUpCustomers() {
        Customer customer1 = new Customer("James Madison");
        Customer customer2 = new Customer("Zackery Taylor");
        Customer customer3 = new Customer("Benjamin Harrison");
        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);
        customerService.saveCustomer(customer3);
    }
}
