package com.aviatrade.controllers;

import com.aviatrade.entity.Aircraft;
import com.aviatrade.entity.User;
import com.aviatrade.model.Input;
import com.aviatrade.service.AircraftService;
import com.aviatrade.service.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AircraftAPI {

    @Autowired
    private AircraftService airService;
    @PostMapping("/aircrafts")
    public List<Aircraft> showAll (@ModelAttribute("myInput") Input input) {
        if(input.getAircraftName()!=null){
            System.out.println(input.getAircraftName());
            return airService.findAllByName(input.getAircraftName());
        }
        return airService.getAll();
    }



    @PostMapping("/aircraft")
    public Aircraft sellAir (@ModelAttribute("newplane") Aircraft air) {
        UserPrincipal usr = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Aircraft theAircraft = new Aircraft(air.getName(),air.getManufacture(),
                air.getLocation(),air.getSn(),air.getTtaf(),usr.getUser(),air.getReg());

        return airService.save(theAircraft);
    }

}
