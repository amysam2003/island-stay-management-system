package com.islandstay.islandstay.model;
public class Guest {
    private int id;
    private String name;
    private String email;

    // I used this default constructor to create empty Guest objects
    public Guest() {}

    // Used this to initialize a Guest with all records/details
    public Guest(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // These are the getters I used, to retrieve the Guest Records
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // These are the setters I used, to update the Guest Records
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}