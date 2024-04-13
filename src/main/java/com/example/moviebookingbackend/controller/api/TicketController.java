package com.example.moviebookingbackend.controller.api;
import com.example.moviebookingbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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
