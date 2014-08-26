package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.service.MovieService;
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
public class SetBasedMovieRepository implements MovieRepository {
    @Autowired
    private MovieService movieService;

    public void add(final Movie entity) throws NullObjectAddedException {
        if (entity == null) {
            throw new NullObjectAddedException();
        }
        movieService.saveMovie(entity);
    }

    @Override
    public void add(final Collection<Movie> entities) throws NullObjectAddedException {
        if (entities == null) {
            throw new IllegalArgumentException();
        }
        for (final Movie entity : entities) {
            if (entity == null) {
                throw new NullObjectAddedException();
            }
            movieService.saveMovie(entity);
        }
    }

    @Override
    public List<Movie> selectAll() {
        return movieService.getAllMovies();
    }

    @Override
    public List<Movie> selectAll(final Comparator<Movie> comparator) {
        final List<Movie> result = movieService.getAllMovies();
        Collections.sort(result, comparator);
        return result;
    }

    @Override
    public List<Movie> selectSatisfying(final Specification<Movie> specification) {
        return selectSatisfyingIntoCollection(specification);
    }

    @Override
    public List<Movie> selectSatisfying(final Specification<Movie> specification, final Comparator<Movie> comparator) {
        final List<Movie> result = selectSatisfyingIntoCollection(specification);
        Collections.sort(result, comparator);
        return result;
    }

    @Override
    public Movie selectUnique(final Specification<Movie> specification) throws NonUniqueObjectSelectedException {
        final List<Movie> results = selectSatisfyingIntoCollection(specification);
        if (results.size() == 1) {
            return results.get(0);
        } else if (!results.isEmpty()) {
            throw new NonUniqueObjectSelectedException();
        }
        return null;
    }

    private List<Movie> selectSatisfyingIntoCollection(final Specification<Movie> specification) {
        List<Movie> target = new ArrayList<Movie>();
        for (Movie object : movieService.getAllMovies()) {
            if (specification.isSatisfiedBy(object)) {
                target.add(object);
            }
        }
        return target;
    }

    @Override
    public List<Movie> withTitles(String... titles) {
        return movieService.getMovies(titles);
    }
}
