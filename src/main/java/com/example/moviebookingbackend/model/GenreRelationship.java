package com.example.moviebookingbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genre_relationships")
//@IdClass(GenreRelationshipId.class)
public class GenreRelationship {
    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // Getters and setters
}
