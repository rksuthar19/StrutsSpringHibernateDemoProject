package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
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
        customerService.saveCustomer(new Customer("suthar"));
    }
}
