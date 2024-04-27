package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movies", nativeQuery = true)
    List<Movie> findAllMoviesQuery();

    @Query("SELECT m FROM Movie m JOIN Showtime s ON m.id = s.movieId WHERE DATE(s.showTime) = CURRENT_DATE")
    List<Movie> findMoviesWithShowtimesToday();

    @Query("SELECT m FROM Movie m JOIN Showtime s ON m.id = s.movieId WHERE DATE(s.showTime) > CURRENT_DATE")
    List<Movie> findMoviesWithShowtimesUpcoming();

    @Query("SELECT m FROM Movie m JOIN Showtime s ON m.id = s.movieId " +
            "JOIN Ticket t ON s.id = t.showtimeId " +
            "WHERE t.id = :ticketId")
    List<Movie> findMovieByTicketId(@Param("ticketId") int ticketId);
}