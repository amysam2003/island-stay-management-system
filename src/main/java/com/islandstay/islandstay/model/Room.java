package com.islandstay.islandstay.model;
public class Room {
    private int id;
    private String name;
    private double price;

    // I used this default constructor to create empty Room objects
    public Room() {}

    // Used this to initialize a Room with all details
    public Room(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // These are the getters I used, to retrieve the Room Details
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // These are the setters I used, to update any of the Room Detais
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}