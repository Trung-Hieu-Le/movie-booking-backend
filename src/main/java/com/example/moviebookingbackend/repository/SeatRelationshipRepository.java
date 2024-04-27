package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.model.SeatRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRelationshipRepository extends JpaRepository<SeatRelationship, Integer> {
    @Query("SELECT sr.seat FROM SeatRelationship sr " +
            "JOIN Ticket t ON t.id = sr.ticketId " +
            "WHERE t.id = :ticketId")
    List<String> findSeatsByTicketId(@Param("ticketId") int ticketId);
}
