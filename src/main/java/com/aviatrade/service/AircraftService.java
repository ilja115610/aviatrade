package com.aviatrade.service;

import com.aviatrade.entity.Aircraft;
import com.aviatrade.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AircraftService {

    @Autowired
    private AircraftRepository repository;


    public List<Aircraft> findAllByName (String name) {
        return repository.findAllByNameContainingIgnoreCase(name);
    }

    public Aircraft getAircraft (String name) {
        return repository.findByName(name);
    }

    public List<Aircraft> getAll() {
        return repository.findAllByOrderByAircraftIdAsc();
    }

    public Aircraft getLastOne(){
        return repository.findFirstByOrderByAircraftIdDesc();
    }

    public Aircraft save(Aircraft air){
        return repository.saveAndFlush(air);
    }

}
