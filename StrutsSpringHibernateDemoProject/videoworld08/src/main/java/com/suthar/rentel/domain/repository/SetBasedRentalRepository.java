package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Customer;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.model.Rental;
import com.suthar.rentel.domain.service.RentalService;
import com.suthar.rentel.domain.specification.AndSpecification;
import com.suthar.rentel.domain.specification.CurrentRentalSpecification;
import com.suthar.rentel.domain.specification.RentalForCustomerSpecification;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedRentalRepository implements RentalRepository {

    @Autowired
    private RentalService rentalService;

    public SetBasedRentalRepository() {
        super();
    }

    @Override
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

    @Override
    public void add(final Rental entity) throws NullObjectAddedException {
        if (entity == null) {
            throw new NullObjectAddedException();
        }
        rentalService.saveRental(entity);
    }

    @Override
    public void add(final Collection<Rental> entities) throws NullObjectAddedException {
        if (entities == null) {
            throw new IllegalArgumentException();
        }
        for (final Rental entity : entities) {
            if (entity == null) {
                throw new NullObjectAddedException();
            }
            rentalService.saveRental(entity);
        }
    }

    @Override
    public List<Rental> selectAll() {
        return rentalService.getAllRentals();
    }

    @Override
    public Set<Rental> selectAll(final Comparator<Rental> comparator) {
        final List<Rental> result = rentalService.getAllRentals();
        Collections.sort(result, comparator);
        return new LinkedHashSet<Rental>(result);
    }

    @Override
    public Set<Rental> selectSatisfying(final Specification<Rental> specification) {
        return selectSatisfyingIntoCollection(specification, new HashSet<Rental>());
    }

    @Override
    public Set<Rental> selectSatisfying(final Specification<Rental> specification, final Comparator<Rental> comparator) {
        final List<Rental> result = selectSatisfyingIntoCollection(specification, new ArrayList<Rental>());
        Collections.sort(result, comparator);
        return new LinkedHashSet<Rental>(result);
    }

    @Override
    public Rental selectUnique(final Specification<Rental> specification) throws NonUniqueObjectSelectedException {
        final List<Rental> results = selectSatisfyingIntoCollection(specification, new ArrayList<Rental>());
        if (results.size() == 1) {
            return results.get(0);
        } else if (!results.isEmpty()) {
            throw new NonUniqueObjectSelectedException();
        }
        return null;
    }

    private <C extends Collection<Rental>> C selectSatisfyingIntoCollection(final Specification<Rental> specification,
                                                                            final C target) {
        for (Rental object : rentalService.getAllRentals()) {
            if (specification.isSatisfiedBy(object)) {
                target.add(object);
            }
        }
        return target;
    }

}
