package com.suthar.rentel.domain.ui.action;

import com.suthar.rentel.ui.action.LoginAction;
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
@ContextConfiguration(locations = "LoginActionTest-context.xml")
public class LoginActionTest {
    @Autowired
    private LoginAction loginAction;

    @Test
    public void testGetCustomers() {
        System.out.print(loginAction.getCustomers());
        Assert.assertNotNull(loginAction.getCustomers());
    }
}
