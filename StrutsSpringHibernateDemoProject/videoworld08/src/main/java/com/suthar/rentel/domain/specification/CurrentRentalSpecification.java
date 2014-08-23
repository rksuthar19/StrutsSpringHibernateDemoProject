package com.suthar.rentel.domain.specification;


import com.suthar.rentel.domain.model.Rental;
import org.joda.time.LocalDateTime;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class CurrentRentalSpecification implements Specification<Rental> {

    @Override
    public boolean isSatisfiedBy(final Rental rental) {
        return !rental.getEndDate().isBefore(new LocalDateTime());
    }

}
