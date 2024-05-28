package com.example.moviebookingbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;

public class ShowtimeInfo {
    private int id;
    private int movieId;
//    private int cinemaId;
    private Date showTime;
    private List<String> seats;

    public ShowtimeInfo() {
    }

    public ShowtimeInfo(int id, int movieId, Date showTime, List<String> seats) {
        this.id = id;
        this.movieId = movieId;
        this.showTime = showTime;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

//    public int getCinemaId() {
//        return cinemaId;
//    }
//
//    public void setCinemaId(int cinemaId) {
//        this.cinemaId = cinemaId;
//    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
