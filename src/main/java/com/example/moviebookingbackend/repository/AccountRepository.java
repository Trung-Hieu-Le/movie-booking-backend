package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNameAndPassword(String name, String password);
}
