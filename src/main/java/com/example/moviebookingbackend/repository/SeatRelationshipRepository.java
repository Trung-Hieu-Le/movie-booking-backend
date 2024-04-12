package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.SeatRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRelationshipRepository extends JpaRepository<SeatRelationship, Integer> {
}
