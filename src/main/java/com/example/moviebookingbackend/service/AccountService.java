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

    public Account loginAction(String phone, String password) {
//        if (accountRepository.findByPhoneAndPassword(phone, password) == null) {
//            throw new Exception("Wrong phone or password");
//        }
        return accountRepository.findByPhoneAndPassword(phone, password);
    }

    public Account registerAction(Account account) throws Exception {
        if (accountRepository.findByPhone(account.getPhone()) != null) {
            throw new Exception("Phone already exists");
        }

        return accountRepository.save(account);
    }

    public boolean changePassword(int accountId, String newPassword) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
//            Account account = optionalAccount.get();
            account.setPassword(newPassword);
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    public boolean updateAccount(int accountId, String newName, String newPhone, String newEmail, Date newBirthday, String newGender) {
        Account account = accountRepository.findById(accountId);
        if (account != null) {
//            Account account = accountOptional.get();
            account.setName(newName);
            account.setPhone(newPhone);
            account.setEmail(newEmail);
            account.setPassword(account.getPassword());
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

    public boolean forgetPassword(String phone, String email, String newPassword) {
        Account account = accountRepository.findByPhoneAndEmail(phone, email);

        if (account != null) {
            account.setPassword(newPassword);
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }
}
