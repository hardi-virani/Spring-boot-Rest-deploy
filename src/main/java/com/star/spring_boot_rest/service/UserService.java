package com.star.spring_boot_rest.service;

import com.star.spring_boot_rest.model.User;
import com.star.spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    //we can also do this in securityConfig. your choice.
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); //$2 $10 in the encoded password - 12 means how many rounds was it been hashed. its not 12 rounds but 2^12

    // we are using bcrypt to just storing a new register. now we will use bcrypt to retrive a user.

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword()); //not a good idea for production.
        return repo.save(user);

    }
}
