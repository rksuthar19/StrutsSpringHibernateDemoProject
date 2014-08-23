package com.suthar.rentel.domain.repository;

import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.specification.MovieWithTitleSpecification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "singleton")
@Component
public class SetBasedMovieRepository extends SetBasedRepository<Movie> implements MovieRepository {
    public SetBasedMovieRepository() {
        super(Repo.movieList);
    }

    @Override
    public Set<Movie> withTitles(final String... titles) {
        return selectSatisfying(new MovieWithTitleSpecification("a"));
    }
}
