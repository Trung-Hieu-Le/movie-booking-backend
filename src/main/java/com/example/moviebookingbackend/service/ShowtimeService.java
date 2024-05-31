package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.model.ShowtimeInfo;
import com.example.moviebookingbackend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;

//    public List<Cinema> getCinemasByMovieId(int movieId) {
//        return showtimeRepository.findCinemasByMovieId(movieId);
//    }

//    public List<Showtime> getShowtimeByMovieIdAndCinemaId(int movieId, int cinemaId) {
//        return showtimeRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
//    }

//    public List<ShowtimeInfo> findShowtimeWithSeats(int movieId, int cinemaId) {
//        Map<String, Object> result = new HashMap<>();
//
//        // Find Showtime
//        List<Showtime> showtimes = showtimeRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
//        result.put("showtimes", showtimes);
//
//        // Find and merge Seats for all Showtimes
//        Map<Showtime, List<String>> seatsMap = new HashMap<>();
//        for (Showtime showtime : showtimes) {
//            List<String> seats = showtimeRepository.findSeatsByShowtimeId(showtime.getId());
//            seatsMap.put(showtime, seats);
//            result.put("seatsMap", seatsMap);
//
//        }
//
//        return result;
//
//        List<Showtime> showtimes = showtimeRepository.findByMovieIdAndCinemaId(movieId, cinemaId);
//        List<ShowtimeInfo> showtimeInfos = new ArrayList<>();
//        for (Showtime showtime : showtimes) {
//            List<String> seats = showtimeRepository.findSeatsByShowtimeId(showtime.getId());
//            ShowtimeInfo showtimeInfo = new ShowtimeInfo();
//            showtimeInfo.setId(showtime.getId());
//            showtimeInfo.setMovieId(showtime.getMovieId());
////            showtimeInfo.setCinemaId(showtime.getCinemaId());
//            showtimeInfo.setShowTime(showtime.getShowTime());
//            showtimeInfo.setSeats(seats);
//            showtimeInfos.add(showtimeInfo);
//        }
//        return showtimeInfos;
//    }

    public List<ShowtimeInfo> findShowtime(int movieId) {
        List<Showtime> showtimes = showtimeRepository.findByMovieIdSortByShowtime(movieId);
        List<ShowtimeInfo> showtimeInfos = new ArrayList<>();
        for (Showtime showtime : showtimes) {
            List<String> seats = showtimeRepository.findSeatsByShowtimeId(showtime.getId());
            ShowtimeInfo showtimeInfo = new ShowtimeInfo();
            showtimeInfo.setId(showtime.getId());
            showtimeInfo.setMovieId(showtime.getMovieId());
            showtimeInfo.setShowTime(showtime.getShowTime());
            showtimeInfo.setSeats(seats);
            showtimeInfos.add(showtimeInfo);
        }
        return showtimeInfos;
    }

    public List<String> findSeats(int movieId, int showtimeId) {
        List<String> seats = showtimeRepository.findSeatsByShowtimeId(showtimeId);
        return seats;
    }
}
