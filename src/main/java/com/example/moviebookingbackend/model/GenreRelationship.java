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

    public GenreRelationship() {
    }

    public GenreRelationship(Movie movie, Genre genre) {
        this.movie = movie;
        this.genre = genre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
