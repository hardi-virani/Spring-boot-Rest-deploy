package com.star.spring_boot_rest;

import com.star.spring_boot_rest.model.JobPost;
import com.star.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping("jobPosts")
//    @ResponseBody  //Instead of this we have written @RestController
    public List<JobPost> getAllJobs() {
        System.out.println("Endpoint Hit");
            return service.getAllJobs();
    }

}
