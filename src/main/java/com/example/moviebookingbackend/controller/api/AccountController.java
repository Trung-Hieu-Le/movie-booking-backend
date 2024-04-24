package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.model.ApiResponse;
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
            ApiResponse response = new ApiResponse("success", savedAccount, "Account registered successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Failed to register account");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String phone = credentials.get("phone");
            String password = credentials.get("password");
            if (phone == null || phone.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                ApiResponse response = new ApiResponse("fail", null, "Phone or password cannot be empty or contain only spaces");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            if (!phone.matches("\\d+")){
                ApiResponse response = new ApiResponse("fail", null, "Phone must be number only");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            Account existingAccount = accountService.loginAction(phone, password);
            if (existingAccount != null && existingAccount.getPassword().equals(password)) {
                ApiResponse response = new ApiResponse("success", existingAccount, "Login successful");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Wrong phone or password");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Failed to login");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-account/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable int accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
//            return new ResponseEntity<>(account, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", account, "Get account successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Account not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/change-password/{accountId}/{password}")
    public ResponseEntity<?> changePassword(@PathVariable int accountId, @PathVariable String newPassword) {
        boolean success = accountService.changePassword(accountId, newPassword);
        if (success) {
//            return ResponseEntity.ok("Password changed successfully");
            ApiResponse response = new ApiResponse("success", null, "Password changed successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            ApiResponse response = new ApiResponse("fail", null, "Account not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-account/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable int accountId, @RequestBody Map<String, String> accountDetails) {
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
//            return new ResponseEntity<>("Invalid date format", HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Invalid date format");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        boolean updated = accountService.updateAccount(accountId, newName, newPhone, newEmail, newPassword, newBirthday, newGender);
        if (updated) {
//            return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", null, "Account updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Account not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}

