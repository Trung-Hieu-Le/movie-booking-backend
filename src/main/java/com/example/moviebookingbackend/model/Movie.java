package com.example.moviebookingbackend.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private String image;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "age_limit")
    private int ageLimit;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String actors;

    @Column(nullable = false)
    private int price;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "movie_id")
//    private List<Showtime> showtimes;

//    @ManyToMany
//    @JoinTable(
//            name = "genre_relationships",
//            joinColumns = @JoinColumn(name = "movie_id"),
//            inverseJoinColumns = @JoinColumn(name = "genre_id")
//    )
//    private List<Genre> genres;
//    private List<String> genres;

    public Movie(){}

    public Movie(String title, String description, String image, int ageLimit, String director, int price, String actors, Date releaseDate) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.ageLimit = ageLimit;
        this.director = director;
        this.price = price;
        this.actors = actors;
        this.releaseDate = releaseDate;
//        this.showtimes = showtimes;
//        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

//    public List<Showtime> getShowtimes() {
//        return showtimes;
//    }
//
//    public void setShowtimes(List<Showtime> showtimes) {
//        this.showtimes = showtimes;
//    }

//    public List<String> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(List<String> genres) {
//        this.genres = genres;
//    }
}
