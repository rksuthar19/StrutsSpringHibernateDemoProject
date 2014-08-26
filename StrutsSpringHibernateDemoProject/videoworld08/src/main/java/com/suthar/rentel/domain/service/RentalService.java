package com.suthar.rentel.domain.service;

import com.suthar.rentel.domain.model.Rental;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Service
public class RentalService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Rental getRental(long id) {
        return entityManager.find(Rental.class, id);
    }

    @Transactional
    public List<Rental> getAllRentals() {
        return (List<Rental>) entityManager.createQuery("from " + Rental.class.toString());
    }

    @Transactional
    public Rental saveRental(Rental rental) {
        return entityManager.merge(rental);
    }

    @Transactional
    public List<Rental> getRentalByCustomerId(String customerId) {
        return (List<Rental>) entityManager.createQuery("from " + Rental.class.toString() + " where customer.id = " + customerId);
    }
}