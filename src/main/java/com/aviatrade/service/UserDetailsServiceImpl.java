package com.aviatrade.service;

import com.aviatrade.entity.User;
import com.aviatrade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User theUser = repository.findByUsername(s);
        if(theUser==null){
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(theUser);
    }
}
