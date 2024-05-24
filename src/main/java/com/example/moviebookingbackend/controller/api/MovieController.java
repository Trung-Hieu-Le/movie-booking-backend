package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.ApiResponse;
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
//            return new ResponseEntity<>(movies, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all-movies-today")
    public ResponseEntity<?> getAllMoviesToday() {
        try {
//            List<Movie> movies = movieService.getAllMovies();
            List<Movie> movies = movieService.getAllMoviesWithShowtimesToday();
//            return new ResponseEntity<>(movies, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all-movies-upcoming")
    public ResponseEntity<?> getAllMoviesUpcoming() {
        try {
//            List<Movie> movies = movieService.getAllMovies();
            List<Movie> movies = movieService.getAllMoviesWithShowtimesUpcoming();
//            return new ResponseEntity<>(movies, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable int movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
//            return new ResponseEntity<>(movie, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", movie, "Lấy chi tiết phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Lấy chi tiết phim thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}