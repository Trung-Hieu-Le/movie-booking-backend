package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Cinema;
import com.example.moviebookingbackend.model.Showtime;
import com.example.moviebookingbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT c FROM Cinema c JOIN Showtime s ON c.id = s.cinemaId WHERE s.movieId = :movieId")
    List<Cinema> findCinemasByMovieId(@Param("movieId") int movieId);

    List<Showtime> findByMovieIdAndCinemaId(int movieId, int cinemaId);

    @Query("SELECT sr.seat FROM SeatRelationship sr " +
            "JOIN Ticket t ON t.id = sr.ticketId " +
            "WHERE t.showtimeId = :showtimeId")
    List<String> findSeatsByShowtimeId(@Param("showtimeId") int showtimeId);
    @Query("SELECT t FROM Ticket t WHERE t.showtimeId = :showtimeId")
    List<Ticket> findTicketsByShowtimeId(@Param("showtimeId") int showtimeId);
    @Query("SELECT s.showTime FROM Showtime s " +
            "JOIN Ticket t ON s.id = t.showtimeId " +
            " WHERE t.id = :ticketId")
    Date findShowtimeByTicketId(@Param("ticketId") int ticketId);

    @Query("SELECT s FROM Showtime s WHERE s.movieId = :movieId ORDER BY s.showTime")
    List<Showtime> findByMovieIdSortByShowtime(int movieId);
}

