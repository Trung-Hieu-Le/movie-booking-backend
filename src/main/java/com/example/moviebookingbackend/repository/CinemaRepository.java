package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
