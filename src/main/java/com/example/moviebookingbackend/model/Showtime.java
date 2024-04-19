package com.example.moviebookingbackend.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "showtimes")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "cinema_id")
    private int cinemaId;

    @Column(name = "show_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date showTime;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "showtime_id")
//    private List<Ticket> tickets;

    public Showtime(){}

    public Showtime(int movieId, int cinemaId, Date showTime) {
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.showTime = showTime;
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

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

}

