package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.ApiResponse;
import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.model.MovieInfo;
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
            List<MovieInfo> movies = movieService.getAllMoviesQuery();
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all-movies-today")
    public ResponseEntity<?> getAllMoviesToday() {
        try {
            List<Movie> movies = movieService.getAllMoviesWithShowtimesToday();
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all-movies-upcoming")
    public ResponseEntity<?> getAllMoviesUpcoming() {
        try {
            List<Movie> movies = movieService.getAllMoviesWithShowtimesUpcoming();
            ApiResponse response = new ApiResponse("success", movies, "Lấy danh sách phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách phim thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable int movieId) {
        try {
            MovieInfo movie = movieService.getMovieById(movieId);
            if (movie != null) {
                ApiResponse response = new ApiResponse("success", movie, "Lấy chi tiết phim thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy chi tiết phim");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy chi tiết phim thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
}