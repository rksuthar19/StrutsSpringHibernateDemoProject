package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.specification.Specification;
import com.suthar.rentel.domain.util.NonUniqueObjectSelectedException;
import com.suthar.rentel.domain.util.NullObjectAddedException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public interface MovieRepository {
    void add(Movie entity) throws NullObjectAddedException;

    void add(Collection<Movie> entities) throws NullObjectAddedException;

    List<Movie> selectAll();

    List<Movie> selectAll(Comparator<Movie> comparator);

    List<Movie> selectSatisfying(Specification<Movie> specification);

    List<Movie> selectSatisfying(Specification<Movie> specification, Comparator<Movie> comparator);

    Movie selectUnique(Specification<Movie> specification) throws NonUniqueObjectSelectedException;

    List<Movie> withTitles(String... titles);
}