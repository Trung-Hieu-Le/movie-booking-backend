package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movies", nativeQuery = true)
    List<Movie> findAllMoviesQuery();
}