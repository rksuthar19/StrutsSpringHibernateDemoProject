package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public interface RentalRepository {
    void add(Rental entity) throws NullObjectAddedException;

    void add(Collection<Rental> entities) throws NullObjectAddedException;

    List<Rental> selectAll();

    List<Rental> selectAll(Comparator<Rental> comparator);

    List<Rental> selectSatisfying(Specification<Rental> specification);

    List<Rental> selectSatisfying(Specification<Rental> specification, Comparator<Rental> comparator);

    Rental selectUnique(Specification<Rental> specification) throws NonUniqueObjectSelectedException;

    List<Rental> currentRentalsFor(Customer customer);

    Rental findRental(Movie movie);
}