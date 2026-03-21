package com.islandstay.islandstay.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// I used this annotation to map this class to my MongoDB's "test" database's collection "islandreviews"
@Document(collection = "islandreviews")
public class Review {

    // Used this @id to uniquely identify each review in the MongoDB
    @Id
    private String id;
    private String room;
    private String guest;
    private int rating;
    private String comment;

    // I used this default constructor just to create empty Review objects
    public Review() {}

    // Used this to in order to initialize a Review with all details
    public Review(String room, String guest, int rating, String comment) {
        this.room = room;
        this.guest = guest;
        this.rating = rating;
        this.comment = comment;
    }

    // These are the getters I used, to retrieve the Review Detais
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRoom() { return room; }
    public void setRoom(String room) { this.room = room; }
    public String getGuest() { return guest; }
    public void setGuest(String guest) { this.guest = guest; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}