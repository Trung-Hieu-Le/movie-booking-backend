package com.example.moviebookingbackend.model;

import java.util.Date;
import java.util.List;

public class TicketInfo {
    private String movieTitle;
    private String movieImage;
    private String movieDescription;
    private Date showTime;
    private Date createdAt;
    private List<String> seats;
    private int totalPrice;

    public TicketInfo() {
    }

    public TicketInfo(String movieTitle, String movieImage, Date showTime, List<String> seats, int totalPrice, String movieDescription, Date createdAt) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
        this.showTime = showTime;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.movieDescription = movieDescription;
        this.createdAt = createdAt;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
