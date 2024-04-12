package com.example.moviebookingbackend.controller.api;
import com.example.moviebookingbackend.model.Ticket;
import com.example.moviebookingbackend.repository.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @PostMapping("/book")
//    public ResponseEntity<?> bookTicket(@RequestParam int accountId,
//                                        @RequestParam int showtimeId,
//                                        @RequestParam List<Integer> seats,
//                                        @RequestParam int totalPrice) {
//        try {
//            Ticket bookedTicket = ticketService.bookTicket(accountId, showtimeId, seats, totalPrice);
//            return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error booking ticket");
//        }
//    }
}
