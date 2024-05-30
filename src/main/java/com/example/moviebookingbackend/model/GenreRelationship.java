package com.example.moviebookingbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genre_relationships")
//@IdClass(GenreRelationshipId.class)
public class GenreRelationship {
    @Id
    @Column(name = "movie_id")
    private int movieId;
    @Id
    @Column(name = "genre_id")
    private int genreId;

    public GenreRelationship(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
