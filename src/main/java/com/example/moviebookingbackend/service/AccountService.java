package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Account;
import com.example.moviebookingbackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;


import java.util.List;
import java.util.Optional;

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

        return accountRepository.save(account);
    }

    public boolean updateAccount(int accountId, String newName, String newPhone, String newEmail, String newPassword, Date newBirthday, String newGender) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
//            Account account = accountOptional.get();
            account.setName(newName);
            account.setPhone(newPhone);
            account.setEmail(newEmail);
            account.setPassword(newPassword);
            account.setBirthday(newBirthday);
            account.setGender(newGender);
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    public Account getAccountById(int accountId) {
        return accountRepository.findById(accountId);
    }

}
