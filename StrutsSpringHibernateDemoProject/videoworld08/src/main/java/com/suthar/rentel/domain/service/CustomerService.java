package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Service
public class CustomerService {
    @PersistenceContext
    private EntityManager entityManager;

    public Customer getCustomer(Long id){
        return entityManager.find(Customer.class,id);
    }

    public Customer saveCustomer(Customer customer){
        return entityManager.merge(customer);
    }
}