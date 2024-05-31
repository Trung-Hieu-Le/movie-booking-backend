package com.example.moviebookingbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviebookingbackend.model.Ticket;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE t.accountId = :accountId ORDER BY t.id DESC")
    List<Ticket> findByAccountId(int accountId);
//    List<Ticket> findByAccountId(Integer accountId);
}
