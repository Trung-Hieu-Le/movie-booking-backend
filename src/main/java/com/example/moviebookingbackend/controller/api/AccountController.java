package com.example.moviebookingbackend.controller.api;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.model.ApiResponse;
import com.example.moviebookingbackend.repository.AccountRepository;
import com.example.moviebookingbackend.service.AccountService;

import jakarta.servlet.http.HttpSession;

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
            ApiResponse response = new ApiResponse("fail", null, "Đăng ký thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session, @RequestBody Map<String, String> credentials) {
        try {
            String phone = credentials.get("phone");
            String password = credentials.get("password");
            if (phone == null || phone.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                ApiResponse response = new ApiResponse("fail", null, "Số điện thoại và mật khẩu không được để trống");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            // if (!phone.matches("\\d+")){
            // ApiResponse response = new ApiResponse("fail", null, "Số điện thoại chỉ được
            // nhập chữ số");
            // return new ResponseEntity<>(response, HttpStatus.OK);
            // }
            Account existingAccount = accountService.loginAction(phone, password);
            if (existingAccount != null && existingAccount.getPassword().equals(password)) {
                session.setAttribute("accountId", existingAccount.getId());
                ApiResponse response = new ApiResponse("success", existingAccount, "Đăng nhập thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Sai số điện thoại hoặc mật khẩu");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Đăng nhập thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-account/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable int accountId) {
        try {
            Account account = accountService.getAccountById(accountId);
            if (account != null) {
                ApiResponse response = new ApiResponse("success", account, "Lấy thông tin cá nhân thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy tài khoản");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Lấy thông tin cá nhân thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/change-password/{accountId}/{oldPassword}/{newPassword}")
    public ResponseEntity<?> changePassword(@PathVariable int accountId, @PathVariable String oldPassword,
            @PathVariable String newPassword) {
        try {
            boolean success = accountService.changePassword(accountId, oldPassword, newPassword);
            if (success) {
                ApiResponse response = new ApiResponse("success", null, "Đổi mật khẩu thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Sai mật khẩu cũ");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Đổi mật khẩu thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-account/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable int accountId,
            @RequestBody Map<String, String> accountDetails) {
        try {
            String newName = accountDetails.get("name");
            String newPhone = accountDetails.get("phone");
            String newEmail = accountDetails.get("email");
            // String newPassword = accountDetails.get("password");
            String newBirthday0 = accountDetails.get("birthday");
            String newGender = accountDetails.get("gender");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date newBirthday;
            try {
                newBirthday = dateFormat.parse(newBirthday0);
            } catch (Exception e) {
                ApiResponse response = new ApiResponse("fail", null, "Sai định dạng ngày");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            boolean updated = accountService.updateAccount(accountId, newName, newPhone, newEmail, newBirthday,
                    newGender);
            if (updated) {
                ApiResponse response = new ApiResponse("success", null, "Cập nhật thông tin thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Không tìm thấy tài khoản");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Cập nhật thông tin thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody Map<String, String> request) {
        try {
            String phone = request.get("phone");
            String email = request.get("email");
            String newPassword = request.get("newPassword");

            boolean resetRequest = accountService.forgetPassword(phone, email, newPassword);
            if (resetRequest) {
                ApiResponse response = new ApiResponse("success", null, "Đổi mật khẩu thành công");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("fail", null, "Sai số điện thoại hoặc email");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("fail", null, "Đổi mật khẩu thất bại: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
