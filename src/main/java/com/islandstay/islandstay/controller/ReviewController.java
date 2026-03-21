package com.islandstay.islandstay.controller;
import com.islandstay.islandstay.model.Review;
import com.islandstay.islandstay.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/islandreviews")
public class ReviewController {
    private ReviewRepository reviewRepository;

    // I used this to handle the database interactions for the Review Data
    public ReviewController(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    // I used this to get/fetch all Reviews
    @GetMapping
    public List<Review> getAllReviews() {System.out.println("Getting all reviews! Please wait.");
        return reviewRepository.findAll();}

    // I used this to get/fetch a Reviews by a particular id
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable String id) {System.out.println("Please wait! Getting all reviews with the ID," + id);
        return reviewRepository.findById(id).get();}

    // Used this to add a new Review to the Review Data
    @PostMapping
    public Review addReview(@RequestBody Review review) {System.out.println("Yay,Cynthia, New Review has been added successfully.");
        return reviewRepository.save(review);}

    // I used this to update a Review to an existing id
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable String id, @RequestBody Review review)
    {System.out.println("Awesome, the Review has been updated successfully. The ID is:" + id);
        review.setId(id);
        return reviewRepository.save(review);}

    // Used this to delete a specific Review by an id
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable String id)
    {System.out.println("The Review has been deleted successfully and ID is:" + id);
        reviewRepository.deleteById(id);
        return "The Review has been deleted successfully";}
}