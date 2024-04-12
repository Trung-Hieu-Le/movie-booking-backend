package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Ticket;
import com.example.moviebookingbackend.repository.SeatRelationshipRepository;
import com.example.moviebookingbackend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TicketService {
    private TicketRepository ticketRepository;
    private SeatRelationshipRepository seatRelationshipRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, SeatRelationshipRepository seatRelationshipRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRelationshipRepository = seatRelationshipRepository;
    }

//    public Ticket bookTicket(int accountId, int showtimeId, List<Integer> seats, int totalPrice) {
//        // Tạo một vé mới
//        Ticket ticket = new Ticket();
//        ticket.setAccountId(accountId);
//        ticket.setShowtimeId(showtimeId);
//        ticket.setTotalPrice(totalPrice);
//
//        // Lưu vé vào cơ sở dữ liệu và nhận ticketId
//        Ticket savedTicket = ticketRepository.save(ticket);
//        int ticketId = savedTicket.getId();
//
//        // Lưu các ghế vào bảng seat_relationships
//        for (Integer seat : seats) {
//            SeatRelationship seatRelationship = new SeatRelationship();
//            seatRelationship.setTicketId(ticketId);
//            seatRelationship.setSeat(seat);
//            seatRelationshipRepository.save(seatRelationship);
//        }
//
//        return savedTicket;
//    }
}
