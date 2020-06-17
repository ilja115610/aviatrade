package com.aviatrade.service;

import com.aviatrade.entity.User;
import com.aviatrade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {

        return repository.saveAndFlush(user);
    }

    public User findByUserName (String username) {
        return repository.findByUsername(username);
    }

    public boolean isUserPresent (String username){
        User u = repository.findByUsername(username);
        return u != null;
    }
}
