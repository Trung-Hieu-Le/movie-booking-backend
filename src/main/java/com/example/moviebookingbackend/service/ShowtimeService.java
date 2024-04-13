package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
