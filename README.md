# Island Stay Management System 
The Island Stay Management System is a system built to manage a Hotel's main managements such as Bookings, Rooms, Reviews and Guests. 

## Overview
This project is built using the Backend System, API Implementation and Database Integration. Database Integration includes both SQL and NoSQL Databases and the System performs all the CRUD Operations and uses the Clear and Simple Layered-Architecture. Used Java and Spring Boot for this. Here, the SQL and NoSQL are not connected with each other directly, but each of the Database-SQL Database and NoSQL Database is conencted to the Spring Boot Application only. The main is SQL Database. NoSQL Database is used only for demonstration purposes. 

The Project provides the RESTful APIs to perform the CRUD Operations.
It also handles the errors.

The Main and Key Features are:
1.RESTful API Design   
2.CRUD Operations for each and every Entity 
3.MongoDB and SQL Integration for Databases
4.Global Exception Handling for Errors and Debugging

## The Main Application

The main class to run the project is:
IslandstayApplication.java

Location is:
src/main/java/com/islandstay/islandstay/IslandstayApplication.java

You can run this class to start the Spring Boot application (Tomcat server will start on localhost:8080).

## How to Run The Project

1. Open the project in IntelliJ IDEA
2. Ensure MySQL and MongoDB are running
3. Update the Database Credentials in application.yml
  Location:
  src/main/resources/application.yml
5. Run the Main Application:
   IslandstayApplication.java
6. Use Postman or Browser (Google Chrome) to test APIs

## The API Endpoints mapped in the Project are:
(i) GET    :  /guests  
(ii) POST  :  /rooms  
(iii) PUT  :  /bookings/{id}  
(iv) DELETE:  /api/islandreviews/{id}  

These are the Examples of API Endpoints Used.

## Databases Used:
(i) MySQL for Structured Data, and they include guests, rooms and bookings.
(ii) MongoDB for Unstructured Data and this includes reviews.

## Data Structure:
src/main/java/com/islandstay/islandstay

(i) controller (package): It handles the API Requests
    1.BookingController.java
    2.MainController.java
    3.ReviewController.java
    4.GuestController.java
    5.RoomController.java

(ii) repository (package): It handles the JDBC and MongoDB
     1.ReviewRepository.java
     2.BookingRepository.java
     3.RoomRepository.java
     4.GuestRepository.java
     5.DatabaseConnection.java

(iii) model (package): It handles the Data Structure
      1.Booking.java
      2.Room.java
      3.Review.java
      4.Guest.java

(iv) ExceptionHandling.java: It handles Errors and Debugging
Location: src/main/java/com/islandstay/islandstay/ExceptionHandling.java

(v) IslandstayApplication.java: This is the Main Application - Spring Boot Application 
Location: src/main/java/com/islandstay/islandstay/IslandstayApplication.java

(vi) Under resources (package):
     1.application.yml : This is for the Database Configuration
     Location: src/main/resources/application.yml

