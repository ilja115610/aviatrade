package com.aviatrade.controllers;

import com.aviatrade.entity.Aircraft;
import com.aviatrade.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@org.springframework.stereotype.Controller
public class Controller {

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/img";

    @Autowired
    private AircraftService repository;

    @GetMapping("/login")
    public String showLogin () {
        return "login";
    }

    @GetMapping("/")
    public String goHome () {
        return "default";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/buyair")
    public String buyAircraft() {
        return "buyair";
    }

    @GetMapping("/sellair")
    public String sellAircraft() {
        return "sellair";
    }


    @PostMapping("/upload")
    public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            try {
                Aircraft air = repository.getLastOne();
                air.setImg(file.getOriginalFilename());
                repository.save(air);
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "sellair";
    }






}
