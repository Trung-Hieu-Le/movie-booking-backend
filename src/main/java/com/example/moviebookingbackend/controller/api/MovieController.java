package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/all-movies")
    public ResponseEntity<?> getAllMovies() {
        try {
            // Truy vấn cơ sở dữ liệu để lấy danh sách tất cả các phim
            List<Movie> movies = movieRepository.findAll();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}