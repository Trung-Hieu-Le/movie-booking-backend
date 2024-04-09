package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNameAndPassword(String name, String password);
    Account findByName(String name);
    Account findByPhone(String phone);

}
