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
            ApiResponse response = new ApiResponse("success", savedAccount, "Đăng ký thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Đăng ký thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            String phone = credentials.get("phone");
            String password = credentials.get("password");
            if (phone == null || phone.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                ApiResponse response = new ApiResponse("fail", null, "Số điện thoại và mật khẩu không được để trống");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            if (!phone.matches("\\d+")){
                ApiResponse response = new ApiResponse("fail", null, "Số điện thoại chỉ được nhập chữ số");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            Account existingAccount = accountService.loginAction(phone, password);
            if (existingAccount != null && existingAccount.getPassword().equals(password)) {
                ApiResponse response = new ApiResponse("success", existingAccount, "Đăng nhập thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Sai số điện thoại hoặc mật khẩu");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Đăng nhập thất bại");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-account/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable int accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account != null) {
//            return new ResponseEntity<>(account, HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", account, "Lấy thông tin cá nhân thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy tài khoản");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/change-password/{accountId}/{oldPassword}/{newPassword}")
    public ResponseEntity<?> changePassword(@PathVariable int accountId, @PathVariable String oldPassword, @PathVariable String newPassword) {
        boolean success = accountService.changePassword(accountId, newPassword);
        if (success) {
//            return ResponseEntity.ok("Password changed successfully");
            ApiResponse response = new ApiResponse("success", null, "Đổi mật khẩu thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy tài khoản");
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
            ApiResponse response = new ApiResponse("fail", null, "Sai định dạng ngày");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        boolean updated = accountService.updateAccount(accountId, newName, newPhone, newEmail, newPassword, newBirthday, newGender);
        if (updated) {
//            return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
            ApiResponse response = new ApiResponse("success", null, "Cập nhật thông tin thành công");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
//            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy tài khoản");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}

