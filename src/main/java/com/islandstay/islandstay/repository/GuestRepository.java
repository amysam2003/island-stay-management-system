package com.islandstay.islandstay.repository;
import com.islandstay.islandstay.model.Guest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// Used this class to perform CRUD operations on Guests table in MySQL
public class GuestRepository {
    public ArrayList<Guest> getAllGuests() {
        ArrayList<Guest> guests = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM guests");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Guest guest = new Guest(id, name, email);
                guests.add(guest);
            }
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return guests;
    }
    public Guest getGuestById(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM guests WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Guest(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return null;
    }

    // Used this method to add a New Guest to the Data
    public String addGuest(Guest guest) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO guests VALUES (?, ?, ?)");
            ps.setInt(1, guest.getId());
            ps.setString(2, guest.getName());
            ps.setString(3, guest.getEmail());
            ps.executeUpdate();
            return "Awesome, The Room has been added successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // I used this method to update a guest record by an id
    public String updateGuest(int id, Guest guest) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE guests SET name=?, email=? WHERE id=?");
            ps.setString(1, guest.getName());
            ps.setString(2, guest.getEmail());
            ps.setInt(3, id);
            ps.executeUpdate();
            return "Yay, The Room has been updated successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // Used this method to delete a guest record by an id
    public String deleteGuest(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM guests WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Oohoo!, The Room has been deleted successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }
}