package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Cinema> getCinemasByMovieId(int movieId) {
        return showtimeRepository.findCinemasByMovieId(movieId);
    }

    public List<Showtime> getShowtimeByMovieIdAndCinemaId(int movieId, int cinemaId) {
        return showtimeRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
    }

    public Map<String, Object> findShowtimeWithSeats(int movieId, int cinemaId) {
        Map<String, Object> result = new HashMap<>();

        // Find Showtime
        List<Showtime> showtimes = showtimeRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
        result.put("showtimes", showtimes);

        // Find and merge Seats for all Showtimes
        List<String> allSeats = new ArrayList<>();
        for (Showtime showtime : showtimes) {
            List<String> seats = showtimeRepository.findSeatsByShowtimeId(showtime.getId());
            allSeats.addAll(seats);
        }
        result.put("allSeats", allSeats);

        return result;
    }
}
