package com.islandstay.islandstay.repository;
import com.islandstay.islandstay.model.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// I used this class to perform the CRUD operations on bookings table in MySQL
public class BookingRepository {
    public ArrayList<Booking> getAllBookings() {
        ArrayList<Booking> bookings = new ArrayList<>();
        try {

            // This is to get the MySQL Connection
            Connection con = DatabaseConnection.getConnection();

            // This is to select all the Bookings
            PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int guestId = rs.getInt("guestId");
                int roomId = rs.getInt("roomId");
                Booking booking = new Booking(id, guestId, roomId);
                bookings.add(booking);}
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return bookings;
    }
    public Booking getBookingById(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Booking(
                        rs.getInt("id"),
                        rs.getInt("guestId"),
                        rs.getInt("roomId"));
            }
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return null;
    }

    // I used this method to add a new booking
    public String addBooking(Booking booking) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings VALUES (?, ?, ?)"
            );
            ps.setInt(1, booking.getId());
            ps.setInt(2, booking.getguestId());
            ps.setInt(3, booking.getRoomId());
            ps.executeUpdate();
            return "Yay, The Booking has been added successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // I used this method to update a booking by an id
    public String updateBooking(int id, Booking booking) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE bookings SET guestId=?, roomId=? WHERE id=?");
            ps.setInt(1, booking.getguestId());
            ps.setInt(2, booking.getRoomId());
            ps.setInt(3, id);
            ps.executeUpdate();
            return "Yay, The Booking has been updated successfully";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // Used this method to delete a booking by an id
    public String deleteBooking(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM bookings WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Yay, The Booking has been deleted successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }
}