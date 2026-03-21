package com.islandstay.islandstay.model;
public class Booking {
    private int id;
    private int guestId;
    private int roomId;

    // I used this default constructor just to create empty Booking objects
    public Booking() {}

    // Used this to in order to initialize a Booking with all details
    public Booking(int id, int guestId, int roomId) {
        this.id = id;
        this.guestId = guestId;
        this.roomId = roomId;
    }

    // These are the getters I used, to retrieve the Booking Detais
    public int getId() {return id;}
    public int getguestId() {return guestId;}
    public int getRoomId() {return roomId;}

    // These are the setters I used, to update any of the Booking Detais
    public void setId(int id) {this.id = id;}
    public void setGuestId(int guestId) {this.guestId = guestId;}
    public void setRoomId(int roomId) {this.roomId = roomId;}
}