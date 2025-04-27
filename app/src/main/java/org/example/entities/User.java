package org.example.entities;

import java.util.List;

public class User {

    private String name;

    private String password;
    private String hashedPassword;
    private List<Tickets> bookedTickets;
    private String userId;

    public User(String name, String password, String hashedPassword, List<Tickets> bookedTickets, String userId) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.bookedTickets = bookedTickets;
        this.userId = userId;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Tickets> getBookedTickets() {
        return bookedTickets;
    }

    public void printTickets(){
        for (Tickets bookedTicket : bookedTickets) {
            System.out.println(bookedTicket.ticketsInfo());
        }
    }

    public void setBookedTickets(List<Tickets> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
