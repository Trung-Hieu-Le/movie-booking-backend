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

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private List<SeatRelationship> seatRelationships;

    @Column(name = "total_seat", nullable = false)
    private Integer totalSeat;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    public Ticket(){}
//    public Ticket(Showtime showtime, Account account) {
//        this.showtime = showtime;
//        this.account = account;
//    }


    public Ticket(Account account, List<SeatRelationship> seatRelationships, Integer totalSeat, Integer totalPrice) {
        this.account = account;
        this.seatRelationships = seatRelationships;
        this.totalSeat = totalSeat;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Showtime getShowtime() {
//        return showtime;
//    }
//
//    public void setShowtime(Showtime showtime) {
//        this.showtime = showtime;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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

    public List<SeatRelationship> getSeatRelationships() {
        return seatRelationships;
    }

    public void setSeatRelationships(List<SeatRelationship> seatRelationships) {
        this.seatRelationships = seatRelationships;
    }

//    public String getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(String seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
}
