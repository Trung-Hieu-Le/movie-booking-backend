package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.ApiResponse;
import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.model.ShowtimeInfo;
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
            ApiResponse response = new ApiResponse("success", cinemas, "Lấy danh sách rạp phim thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy danh sách rạp phim thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-showtime/{movieId}")
    public ResponseEntity<?> getShowtimeByMovieId(@PathVariable int movieId) {
        try {
            List<ShowtimeInfo> showtimes = showtimeService.findShowtime(movieId);
            ApiResponse response = new ApiResponse("success", showtimes, "Lấy lịch chiếu thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy lịch chiếu thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-seats/{movieId}/{showtimeId}")
    public ResponseEntity<?> getShowtimeByMovieIdAndShowtimeId(@PathVariable int movieId, @PathVariable int showtimeId) {
        try {
            List<String> showtimes = showtimeService.findSeats(movieId, showtimeId);
            ApiResponse response = new ApiResponse("success", showtimes, "Lấy ghế đã đặt thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy ghế đã đặt thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/get-showtime/{movieId}/{cinemaId}")
//    public ResponseEntity<?> getShowtimeByMovieIdAndCinemaId(@PathVariable int movieId, @PathVariable int cinemaId) {
//        try {
////            List<Showtime> showtimes = showtimeService.getShowtimeByMovieIdAndCinemaId(movieId, cinemaId);
//            List<ShowtimeInfo> showtimes = showtimeService.findShowtimeWithSeats(movieId, cinemaId);
////            return new ResponseEntity<>(showtimes, HttpStatus.OK);
//            ApiResponse response = new ApiResponse("success", showtimes, "Lấy lịch chiếu thành công");
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            ApiResponse response = new ApiResponse("fail", null, "Lấy lịch chiếu thất bại");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
//    }
}
