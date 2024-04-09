package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.repository.AccountRepository;
import com.example.moviebookingbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        try {
            Account savedAccount = accountService.registerAction(account);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) throws Exception {
        try {
            Account existingAccount = accountService.loginAction(account.getName(), account.getPassword());
            if (existingAccount != null && existingAccount.getPassword().equals(account.getPassword())) {
                return new ResponseEntity<>(existingAccount, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("There is an error when connecting to database");
        }
    }

}

