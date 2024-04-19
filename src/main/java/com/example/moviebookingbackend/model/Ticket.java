package com.example.moviebookingbackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "showtime_id", nullable = false)
//    private Showtime showtime;

    @Column(name = "showtime_id")
    private int showtimeId;

    @Column(name = "account_id")
    private int accountId;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "ticket_id")
//    private List<SeatRelationship> seatRelationships;

    @Column(name = "total_seat", nullable = false)
    private Integer totalSeat;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    public Ticket(){}

    public Ticket(int showtimeId, int accountId, Integer totalSeat, Integer totalPrice) {
        this.showtimeId = showtimeId;
        this.accountId = accountId;
//        this.seatRelationships = seatRelationships;
        this.totalSeat = totalSeat;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

//    public List<SeatRelationship> getSeatRelationships() {
//        return seatRelationships;
//    }
//
//    public void setSeatRelationships(List<SeatRelationship> seatRelationships) {
//        this.seatRelationships = seatRelationships;
//    }

    public Integer getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
