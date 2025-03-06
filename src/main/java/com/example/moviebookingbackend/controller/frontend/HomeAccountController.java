package com.example.moviebookingbackend.controller.frontend;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeAccountController {

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/register"})
    public String register() {
        return "register";
    }

    @GetMapping({"/forget-password"})
    public String forgetPassword() {
        return "forget_password";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model, HttpSession session) {
        int accountId = (int) session.getAttribute("accountId");
        model.addAttribute("accountId", accountId);
        return "profile";
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model, HttpSession session) {
        int accountId = (int) session.getAttribute("accountId");
        model.addAttribute("accountId", accountId);
        return "edit_profile";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model, HttpSession session) {
        int accountId = (int) session.getAttribute("accountId");
        model.addAttribute("accountId", accountId);
        return "change_password";
    }
}
