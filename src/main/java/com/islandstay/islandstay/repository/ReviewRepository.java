package com.islandstay.islandstay.repository;
import com.islandstay.islandstay.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
}