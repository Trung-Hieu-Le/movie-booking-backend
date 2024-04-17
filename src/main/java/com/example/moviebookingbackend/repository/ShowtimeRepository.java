package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT c FROM Cinema c JOIN Showtime s ON c.id = s.cinemaId WHERE s.movieId = :movieId")
    List<Cinema> findCinemasByMovieId(@Param("movieId") int movieId);

    List<Showtime> findByMovieIdAndCinemaId(int movieId, int cinemaId);

    @Query("SELECT sr.seat FROM SeatRelationship sr WHERE sr.ticketId = :showtimeId")
    List<String> findSeatsByShowtimeId(@Param("showtimeId") int showtimeId);
}

