package com.example.moviebookingbackend.controller.api;
import com.example.moviebookingbackend.model.ApiResponse;
import com.example.moviebookingbackend.model.Ticket;
import com.example.moviebookingbackend.model.TicketInfo;
import com.example.moviebookingbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/get-tickets-by-account/{accountId}")
    public ResponseEntity<?> getTicketsByAccountId(@PathVariable int accountId) {
        try {
            List<TicketInfo> ticketInfos = ticketService.getTicketsByAccountId(accountId);
            if (!ticketInfos.isEmpty()) {
                ApiResponse response = new ApiResponse("success", ticketInfos, "Lấy lịch sử đặt vé thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("success", null, "Tài khoản chưa đặt vé");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch(Exception e){
            ApiResponse response = new ApiResponse("fail", null, "Lấy lịch sử đặt vé thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/book-ticket")
    public ResponseEntity<?> bookTicket(@RequestBody Map<String, Object> requestBody) {
        try {
            int accountId = (int) requestBody.get("accountId");
            int showtimeId = (int) requestBody.get("showtimeId");
            List<String> seatList = (List<String>) requestBody.get("seatList");
            int totalPrice = (int) requestBody.get("totalPrice");

            ticketService.bookTicket(accountId, showtimeId, seatList, totalPrice);
//            return ResponseEntity.ok("Ticket booked successfully");
            ApiResponse response = new ApiResponse("success", null, "Đặt vé thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to book ticket");
            ApiResponse response = new ApiResponse("fail", null, "Đặt vé thất bại: "+e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
