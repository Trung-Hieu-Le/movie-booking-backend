package com.example.moviebookingbackend.model;

import java.io.Serializable;

public class SeatRelationshipId implements Serializable {
    private int ticketId;
    private String seat;

    public SeatRelationshipId() {
    }

    public SeatRelationshipId(int ticketId, String seat) {
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
