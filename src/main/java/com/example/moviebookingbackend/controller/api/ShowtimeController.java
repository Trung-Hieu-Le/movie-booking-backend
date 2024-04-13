package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("/all-cinemas/{movieId}")
    public ResponseEntity<List<Cinema>> getCinemasByMovieId(@PathVariable int movieId) {
        try {
            List<Cinema> cinemas = showtimeService.getCinemasByMovieId(movieId);
            return new ResponseEntity<>(cinemas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-showtime/{movieId}/{cinemaId}")
    public ResponseEntity<List<Showtime>> getShowtimeByMovieIdAndCinemaId(
            @PathVariable int movieId,
            @PathVariable int cinemaId
    ) {
        try {
            List<Showtime> showtimes = showtimeService.getShowtimeByMovieIdAndCinemaId(movieId, cinemaId);
            return new ResponseEntity<>(showtimes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
