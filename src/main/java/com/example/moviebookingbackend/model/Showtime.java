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

//    @ManyToOne
//    @JoinColumn(name = "movie_id", nullable = false)
//    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;


    @Column(name = "show_time", nullable = false)
    private Date showTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id")
    private List<Ticket> tickets;

    public Showtime(){}

//    public Showtime(Movie movie, Cinema cinema, Date showTime, List<Ticket> tickets) {
//        this.movie = movie;
//        this.cinema = cinema;
//        this.showTime = showTime;
//        this.tickets = tickets;
//    }


    public Showtime(Cinema cinema, Date showTime, List<Ticket> tickets) {
        this.cinema = cinema;
        this.showTime = showTime;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
