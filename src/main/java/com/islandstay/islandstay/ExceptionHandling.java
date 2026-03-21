package com.islandstay.islandstay;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionHandling {

    // I used this to handle all exceptions globally
    @ExceptionHandler(Exception.class)

    // I used this to log errors for debugging
    public String handleException(Exception ex) {System.out.println("Error occurred: " + ex.getMessage());
        return "Oops! Something went wrong. Please try again.";
    }
}