package com.star.spring_boot_rest;

import com.star.spring_boot_rest.model.JobPost;
import com.star.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;


    @GetMapping(path = "jobPosts",  produces = {"application/json"}) // This means, it will only return jSon.
//    @GetMapping( "jobPosts")
//    @ResponseBody  //Instead of this we have written @RestController
    public List<JobPost> getAllJobs() {
//        System.out.println("Endpoint Hit");
            return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping(path = "jobPost", consumes = {"application/xml"}) //Basically, it will only accept the data in xml. if json, it will throw error.
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
        return "deleted";
    }

}
