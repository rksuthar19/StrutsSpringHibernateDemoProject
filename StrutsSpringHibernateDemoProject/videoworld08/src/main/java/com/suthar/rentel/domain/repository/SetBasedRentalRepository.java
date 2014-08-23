package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.specification.AndSpecification;
import com.suthar.rentel.domain.specification.CurrentRentalSpecification;
import com.suthar.rentel.domain.specification.RentalForCustomerSpecification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedRentalRepository extends SetBasedRepository<Rental> implements RentalRepository {

    public SetBasedRentalRepository() {
        super();
    }

    public Rental findRental(Movie movie) {
        for (Object o : selectAll()) {
            if (((Rental) o).getMovie().getTitle().equals(movie.getTitle())) {
                return (Rental) o;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Rental> currentRentalsFor(final Customer customer) {
        return selectSatisfying(new AndSpecification<Rental>(new RentalForCustomerSpecification(customer),
                new CurrentRentalSpecification()));
    }
}
