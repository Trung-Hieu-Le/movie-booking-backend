package com.example.moviebookingbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_relationships")
public class SeatRelationship {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "ticket_id")
//    private Ticket ticket;

    @Id
    private int seat;

    public SeatRelationship() {}

    public SeatRelationship(int seat) {
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
