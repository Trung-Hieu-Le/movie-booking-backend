package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.repository.MovieRepository;
import com.example.moviebookingbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all-movies")
    public ResponseEntity<?> getAllMovies() {
        try {
//            List<Movie> movies = movieService.getAllMovies();
            List<Movie> movies = movieService.getAllMoviesQuery();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}