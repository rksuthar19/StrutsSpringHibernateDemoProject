package com.suthar.rentel.ui.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suthar.rentel.domain.model.Movie;
import com.suthar.rentel.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
@Scope(value = "prototype")
@Component
public class ViewHomeAction extends ActionSupport {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.selectAll();
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
