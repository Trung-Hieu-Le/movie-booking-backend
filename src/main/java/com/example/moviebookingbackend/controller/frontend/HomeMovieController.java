package com.example.moviebookingbackend.controller.frontend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeMovieController {
    @GetMapping({"/movie-detail/{id}"})
    public String movieDetail(@PathVariable int id, Model model, HttpSession session) {
        model.addAttribute("movieId", id);
        model.addAttribute("accountId", session.getAttribute("accountId"));
        return "movie_detail";
    }

    @GetMapping({"/all-movies-today"})
    public String allMoviesToday(HttpSession session, Model model) {
        model.addAttribute("accountId", session.getAttribute("accountId"));
        return "all_movies_today";
    }

    @GetMapping({"/all-movies-upcoming"})
    public String allMoviesUpcoming(HttpSession session, Model model) {
        model.addAttribute("accountId", session.getAttribute("accountId"));
        return "all_movies_upcoming";
    }
}


