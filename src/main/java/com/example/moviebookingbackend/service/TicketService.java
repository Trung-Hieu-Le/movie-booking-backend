package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.*;
import com.example.moviebookingbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private SeatRelationshipRepository seatRelationshipRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;
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
//        for (String seat : seatList) {
//            SeatRelationship seatRelationship = new SeatRelationship();
//            seatRelationship.setTicketId(savedTicket.getId());
//            seatRelationship.setSeat(seat);
//            seatRelationshipRepository.save(seatRelationship);
//        }
        List<SeatRelationship> seatRelationships = new ArrayList<>();
        for (String seat : seatList) {
            SeatRelationship seatRelationship = new SeatRelationship(savedTicket.getId(), seat);
            seatRelationships.add(seatRelationship);
        }

        // Lưu tất cả các mối quan hệ ghế vào cơ sở dữ liệu
        seatRelationshipRepository.saveAll(seatRelationships);
    }

    public List<TicketInfo> getTicketsByAccountId(int accountId) {
        List<Ticket> tickets = ticketRepository.findByAccountId(accountId);
        List<TicketInfo> ticketInfos = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketInfos.add(buildTicketInfo(ticket.getId()));
        }
        return ticketInfos;
    }

    private TicketInfo buildTicketInfo(int ticketId) {
        Movie movie = movieRepository.findMovieByTicketId(ticketId).getFirst();
        Cinema cinema = cinemaRepository.findCinemaByTicketId(ticketId).getFirst();
        Date showTime = showtimeRepository.findShowtimeByTicketId(ticketId);
        List<String> seats = seatRelationshipRepository.findSeatsByTicketId(ticketId);

        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setMovieTitle(movie != null ? movie.getTitle() : "Unknown");
        ticketInfo.setMovieImage(movie != null ? movie.getImage() : "");
        ticketInfo.setCinemaName(cinema != null ? cinema.getName() : "Unknown");
        ticketInfo.setShowTime(showTime);
        ticketInfo.setSeats(seats);

        return ticketInfo;
    }
}
