package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account loginAction(String name, String password) throws Exception {
        if (accountRepository.findByNameAndPassword(name, password) == null) {
            throw new Exception("Wrong username or password");
        }
        return accountRepository.findByNameAndPassword(name, password);
    }

    public Account registerAction(Account account) throws Exception {
        if (accountRepository.findByName(account.getName()) != null) {
            throw new Exception("Username already exists");
        }
        else if (accountRepository.findByPhone(account.getPhone()) != null) {
            throw new Exception("Phone already exists");
        }

        // Lưu người dùng mới vào cơ sở dữ liệu
        return accountRepository.save(account);
    }


}
