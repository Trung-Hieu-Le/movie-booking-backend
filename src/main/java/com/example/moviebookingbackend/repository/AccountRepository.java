package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByPhoneAndPassword(String phone, String password);
    Account findByName(String name);
    Account findByPhone(String phone);
    Account findById(int id);
    Account findByPhoneAndEmail(String phone, String email);
    Account findByIdAndPassword(int accountId, String oldPassword);
}
