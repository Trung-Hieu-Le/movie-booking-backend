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
    private String seat;

    public SeatRelationship() {}

    public SeatRelationship(String seat) {
        this.seat = seat;
    }

    public String getSeat() { return seat; }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
