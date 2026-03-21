package com.islandstay.islandstay.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MainController {

    // I used this to check if the system is running or not. It is to confirm.
    @RequestMapping("/")
    public String home()
    {return "Awesome! Emilyn, Your Island Stay Management System is Running!";}}