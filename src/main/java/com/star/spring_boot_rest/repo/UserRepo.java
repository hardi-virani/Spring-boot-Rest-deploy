package com.star.spring_boot_rest.repo;

import com.star.spring_boot_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User, Integer> {
    //8. Now using this repo which has a method called findUserByUsername.
//    9. And we are using JPA so we don't have to write the SQL queries. (to go MyUserDetialsService)
    User findByUsername(String username);


}
