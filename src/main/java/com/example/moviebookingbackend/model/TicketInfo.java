package com.example.moviebookingbackend.model;

import java.util.Date;
import java.util.List;

public class TicketInfo {
    private String movieTitle;
    private String movieImage;
    private String cinemaName;
    private Date showTime;
    private List<String> seats;

    public TicketInfo() {
    }

    public TicketInfo(String movieTitle, String movieImage, String cinemaName, Date showTime, List<String> seats) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
        this.cinemaName = cinemaName;
        this.showTime = showTime;
        this.seats = seats;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

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
