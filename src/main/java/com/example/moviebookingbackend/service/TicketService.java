package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.SeatRelationship;
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

//    @Autowired
//    public TicketService(TicketRepository ticketRepository, SeatRelationshipRepository seatRelationshipRepository) {
//        this.ticketRepository = ticketRepository;
//        this.seatRelationshipRepository = seatRelationshipRepository;
//    }

    public void bookTicket(int accountId, int showtimeId, List<String> seatList, int totalPrice) {
        // Tạo một đối tượng Ticket mới
        Ticket ticket = new Ticket();
        ticket.setAccountId(accountId);
        ticket.setShowtimeId(showtimeId);
        ticket.setTotalSeat(seatList.size());

        ticket.setTotalPrice(totalPrice);

        // Lưu thông tin vé vào cơ sở dữ liệu
        Ticket savedTicket = ticketRepository.save(ticket);

        // Lưu thông tin vị trí ghế vào cơ sở dữ liệu
        for (String seat : seatList) {
            SeatRelationship seatRelationship = new SeatRelationship();
            seatRelationship.setTicketId(savedTicket.getId());
            seatRelationship.setSeat(seat);
            seatRelationshipRepository.save(seatRelationship);
        }
    }
}
