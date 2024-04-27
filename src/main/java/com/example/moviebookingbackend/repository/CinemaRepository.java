package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query("SELECT c FROM Cinema c JOIN Showtime s ON c.id = s.cinemaId " +
            "JOIN Ticket t ON s.id = t.showtimeId " +
            " WHERE t.id = :ticketId")
    List<Cinema> findCinemaByTicketId(@Param("ticketId") int ticketId);
}
