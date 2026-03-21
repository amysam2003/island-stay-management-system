package com.islandstay.islandstay.controller;
import com.islandstay.islandstay.model.Guest;
import com.islandstay.islandstay.repository.GuestRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/guests")
public class GuestController {

    // Used this to handle the database interactions for the Guest Data
    private GuestRepository guestRepository = new GuestRepository();

    // I used this to get/fetch all Guests
    @GetMapping
    public List<Guest> getGuests() {System.out.println("Getting the Guests' Details! Please wait.");
        return guestRepository.getAllGuests();}

    // I used this to add a New Guest
    @PostMapping
    public String addGuest(@RequestBody Guest guest) {System.out.println("Yay! A New Guest has been added successfully and Guest name is:" + guest.getName());
        return guestRepository.addGuest(guest);}

    //  I used this is to update a guest record to an existing id
    @PutMapping("/{id}")
    public String updateGuest(@PathVariable int id, @RequestBody Guest guest) {
        System.out.println("Awesome, the Guest has been updated successfully and the ID is:" + id);
        return guestRepository.updateGuest(id, guest);}

    //  This is to delete a guest record of an existing id
    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable int id) {
        System.out.println("The Guest has been deleted successfully and the ID is:" + id);
        guestRepository.deleteGuest(id);
        return "The Guest has been deleted successfully.";
    }
}