package com.example.moviebookingbackend.controller.frontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.moviebookingbackend.model.TicketInfo;
import com.example.moviebookingbackend.service.TicketService;
import com.example.moviebookingbackend.service.MovieService;
import com.example.moviebookingbackend.model.MovieInfo;

import org.springframework.ui.Model;
import java.util.List;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeTicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private HttpSession session;

    @Autowired
    private MovieService movieService; // Assuming you have a MovieService to fetch movie details

    @GetMapping("/get-tickets-by-account/{accountId}")
    public String viewTickets(@PathVariable int accountId, Model model) {
        try {
            Integer sessionAccountId = (Integer) session.getAttribute("accountId");
            if (sessionAccountId == null || sessionAccountId != accountId) {
                model.addAttribute("tickets", null);
                model.addAttribute("message", "Bạn không đủ quyền xem lịch sử đặt vé người khác");
                return "ticket_by_account_list";
            }

            List<TicketInfo> ticketInfos = ticketService.getTicketsByAccountId(accountId);
            if (!ticketInfos.isEmpty()) {
                model.addAttribute("tickets", ticketInfos);
                model.addAttribute("message", "Lịch sử đặt vé");
            } else {
                model.addAttribute("tickets", null);
                model.addAttribute("message", "Bạn chưa đặt vé nào");
            }
        } catch (Exception e) {
            model.addAttribute("tickets", null);
            model.addAttribute("message", "Lỗi khi lấy dữ liệu: " + e.getMessage());
        }
        return "ticket_by_account_list";
    }

    @GetMapping("/book/{movieId}")
    public String bookTicketPage(@PathVariable int movieId, Model model, HttpSession session) {
        Integer accountId = (Integer) session.getAttribute("accountId");
        MovieInfo movie = movieService.getMovieById(movieId); // Fetch movie details using movieId
        model.addAttribute("movieId", movieId);
        model.addAttribute("accountId", accountId != null ? accountId : 0);
        model.addAttribute("movieTitle", movie.getTitle());
        model.addAttribute("movieImage", movie.getImage());
        model.addAttribute("movieDescription", movie.getDescription());
        model.addAttribute("movieDirector", movie.getDirector());
        model.addAttribute("movieReleaseDate", movie.getReleaseDate());
        model.addAttribute("movieAgeLimit", movie.getAgeLimit());
        model.addAttribute("moviePrice", movie.getPrice());
        return "book_ticket";
    }
}
