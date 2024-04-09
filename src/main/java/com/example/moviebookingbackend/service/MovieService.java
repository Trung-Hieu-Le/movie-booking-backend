package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
