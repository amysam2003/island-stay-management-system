package com.islandstay.islandstay.controller;
import com.islandstay.islandstay.model.Room;
import com.islandstay.islandstay.repository.RoomRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/rooms")
public class RoomController {

    // I used this to handle the database interactions for the Room Data
    private RoomRepository roomRepository = new RoomRepository();

    // I used this to get/fetch all the Rooms
    @GetMapping
    public ArrayList<Room> getRooms() {System.out.println("Getting all the Rooms! Please wait.");
        return roomRepository.getAllRooms();}

    // I used this add new Rooms to the Room Data
    @PostMapping
    public String addRoom(@RequestBody Room room) {
        System.out.println("Yay, a New Room has been added-" + room.getName());
        return roomRepository.addRoom(room);}

    // I used this to update a room to an existing room id
    @PutMapping("/{id}")
    public String updateRoom(@PathVariable int id, @RequestBody Room room) {
        System.out.println("Awesome, the Room has been updated now successfully. ID is:" + id);
        return roomRepository.updateRoom(id, room);}

    // I used this to delete a room by its existing id
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable int id) {
        System.out.println("The Room has been deleted successfully. ID is:" + id);
        roomRepository.deleteRoom(id);
        return "The Room has been deleted successfully.";}
}