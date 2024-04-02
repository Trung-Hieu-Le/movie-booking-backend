package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Bổ sung các phương thức truy vấn tùy chọn nếu cần thiết
}