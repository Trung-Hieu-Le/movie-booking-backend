package com.example.moviebookingbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

public class MovieInfo {

    private int id;
    private String title;
    private String description;
    private String image;
    private Date releaseDate;
    private int ageLimit;
    private String director;
    private String actors;
    private int price;
    private List<String> genres;
    private int duration;

    public MovieInfo() {
    }

    public MovieInfo(int id, String title, String description, String image, Date releaseDate, int ageLimit, String director, String actors, int price, List<String> genres, int duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.releaseDate = releaseDate;
        this.ageLimit = ageLimit;
        this.director = director;
        this.actors = actors;
        this.price = price;
        this.genres = genres;
        this.duration = duration;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
