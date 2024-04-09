package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Ticket;
import com.example.moviebookingbackend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTicketHistoryForAccount(Long accountId) {
        return ticketRepository.findByAccountId(accountId);
    }
}
