package com.suthar.rentel.ui.action;

import com.suthar.rentel.domain.model.Customer;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class ViewAdminActionTest {

    @Test
    public void shouldShowAllUsers() {
        Set<Customer> users = new LinkedHashSet<Customer>();
        users.add(new Customer("John Doe"));

       // SetBasedCustomerRepository customerRepository = new SetBasedCustomerRepository(users);

        ///ViewAdminAction action = new ViewAdminAction(customerRepository);
       // assertThat(action.getUsers(), is(users));
    }

}
