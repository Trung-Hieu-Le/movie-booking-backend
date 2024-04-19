package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.ApiResponse;
import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("/all-cinemas/{movieId}")
    public ResponseEntity<?> getCinemasByMovieId(@PathVariable int movieId) {
        try {
            List<Cinema> cinemas = showtimeService.getCinemasByMovieId(movieId);
//            return new ResponseEntity<>(cinemas, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", cinemas, "Get cinema successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Failed to get cinema");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-showtime/{movieId}/{cinemaId}")
    public ResponseEntity<?> getShowtimeByMovieIdAndCinemaId(
            @PathVariable int movieId,
            @PathVariable int cinemaId
    ) {
//        try {
//            List<Showtime> showtimes = showtimeService.getShowtimeByMovieIdAndCinemaId(movieId, cinemaId);
            Map<String, Object> showtimes = showtimeService.findShowtimeWithSeats(movieId, cinemaId);
//            return new ResponseEntity<>(showtimes, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", showtimes, "Get showtime successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            ApiResponse response = new ApiResponse("fail", null, "Failed to get showtime");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
    }
}
