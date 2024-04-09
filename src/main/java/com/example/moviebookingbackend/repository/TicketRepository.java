package com.example.moviebookingbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviebookingbackend.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByAccountId(Long accountId);
}
