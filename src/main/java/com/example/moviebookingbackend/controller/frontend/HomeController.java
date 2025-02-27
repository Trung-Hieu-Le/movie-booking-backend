package com.example.moviebookingbackend.controller.frontend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // Trả về templates/home.html
    }
}
