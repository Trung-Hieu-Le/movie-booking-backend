package com.example.moviebookingbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_relationships")
public class SeatRelationship {
    @Id
    @Column(name = "ticket_id")
    private int ticketId;

    @Id
    @Column(name = "seat", length = 10)
    private String seat;

    public SeatRelationship() {}

    public SeatRelationship(int ticketId, String seat) {
        this.ticketId = ticketId;
        this.seat = seat;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
