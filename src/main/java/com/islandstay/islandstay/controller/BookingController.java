package com.islandstay.islandstay.controller;
import com.islandstay.islandstay.model.Booking;
import com.islandstay.islandstay.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    // I used this to handle the database interactions for the bookings
    private BookingRepository bookingRepository = new BookingRepository();

    // This is to get/fetch all the bookings
    @GetMapping
    public ArrayList<Booking> getBookings() {System.out.println("Getting the Bookings! Please wait.");
        return bookingRepository.getAllBookings();}

    // This is to add a new booking
    @PostMapping
    public String addBooking(@RequestBody Booking booking) {System.out.println("Yay, New Booking has been added.");
        return bookingRepository.addBooking(booking);}

    // This is to update a booking to an existing id
    @PutMapping("/{id}")
    public String updateBooking(@PathVariable int id, @RequestBody Booking booking)
    {System.out.println("Awesome, the Booking has been updated now successfully. ID is:" + id);
        return bookingRepository.updateBooking(id, booking);}

    // Used this to delete an existing id of Booking
    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable int id)
    {System.out.println("The Booking has been deleted successfully. ID is:" + id);
        return bookingRepository.deleteBooking(id);}
}