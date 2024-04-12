package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.repository.AccountRepository;
import com.example.moviebookingbackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String name = credentials.get("name");
            String password = credentials.get("password");

            Account existingAccount = accountService.loginAction(name, password);
            if (existingAccount != null && existingAccount.getPassword().equals(password)) {
                return new ResponseEntity<>(existingAccount, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/get-account/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable int accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-account/{accountId}")
    public ResponseEntity<String> updateAccount(@PathVariable int accountId, @RequestBody Map<String, String> accountDetails) {
        String newName = accountDetails.get("name");
        String newPhone = accountDetails.get("phone");
        String newEmail = accountDetails.get("email");
        String newPassword = accountDetails.get("password");
        String newBirthday0 = accountDetails.get("birthday");
        String newGender = accountDetails.get("gender");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newBirthday;
        try {
            newBirthday = dateFormat.parse(newBirthday0);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid date format", HttpStatus.BAD_REQUEST);
        }
        boolean updated = accountService.updateAccount(accountId, newName, newPhone, newEmail, newPassword, newBirthday, newGender);
        if (updated) {
            return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
    }
}

