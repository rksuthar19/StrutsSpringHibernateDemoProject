package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.MovieType;
import com.suthar.rentel.domain.model.Rental;
import junit.framework.Assert;
import org.joda.time.LocalDateTime;
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
public class RentalServiceTest {
    @Autowired
    private RentalService rentalService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MovieService movieService;

    @Test
    public void testSaveRental() {

        Customer customer = new Customer("suthar");
        customer=customerService.saveCustomer(customer);

        Movie avatar = new Movie("Avatar", MovieType.NEW);
        avatar = movieService.saveMovie(avatar);

        Rental rental = new Rental(customer,avatar,1, new LocalDateTime());
        rental= rentalService.saveRental(rental);
        Assert.assertEquals("suthar",rental.getCustomer().getName());
        Assert.assertEquals("Avatar",rental.getMovie().getTitle());
        Assert.assertEquals(1,rental.getRentedForDays());
    }

    @Test
    public void setUpCustomers(){
        Customer customer1 = new Customer("James Madison");
        Customer customer2 = new Customer("Zackery Taylor");
        Customer customer3 = new Customer("Benjamin Harrison");
        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);
        customerService.saveCustomer(customer3);
    }
}
