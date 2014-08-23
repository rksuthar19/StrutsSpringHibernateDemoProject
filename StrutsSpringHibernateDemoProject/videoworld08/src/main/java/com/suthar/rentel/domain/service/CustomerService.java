package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Service
public class CustomerService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer getCustomer(String id){
        return entityManager.find(Customer.class,id);
    }

    @Transactional
    public Customer saveCustomer(Customer customer){
        return entityManager.merge(customer);
    }
}