package com.islandstay.islandstay.repository;
import com.islandstay.islandstay.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// I used this class to perform the CRUD operations on Rooms table in MySQL
public class RoomRepository {
    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM rooms");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Room room = new Room(id, name, price);
                rooms.add(room);
            }
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return rooms;
    }
    public Room getRoomById(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM rooms WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Room(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
            }
        } catch (Exception e) {System.out.println("Oh! There is an Error. This is the Error:" + e.getMessage());}
        return null;
    }

    // Used this method to add a new Room
    public String addRoom(Room room) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO rooms VALUES (?, ?, ?)");
            ps.setInt(1, room.getId());
            ps.setString(2, room.getName());
            ps.setDouble(3, room.getPrice());
            ps.executeUpdate();
            return "Great, The Room has been added successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // I used this method to update the Room details by an id
    public String updateRoom(int id, Room room) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE rooms SET name=?, price=? WHERE id=?");
            ps.setString(1, room.getName());
            ps.setDouble(2, room.getPrice());
            ps.setInt(3, id);
            ps.executeUpdate();
            return "Awesome, The Room has been updated successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }

    // Used this method to delete a Room Detail by an id
    public String deleteRoom(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM rooms WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Yay, The Room has been deleted successfully.";
        } catch (Exception e) {return "Oh! There is an Error. This is the Error:" + e.getMessage();}
    }
}