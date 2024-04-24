package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
