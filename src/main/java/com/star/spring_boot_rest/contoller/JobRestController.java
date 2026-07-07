package com.star.spring_boot_rest.contoller;

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

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
       return service.search(keyword);
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

    //to fetch the data in your database, you just need to run the http://localhost:8080/load in postman And then this data will be loaded in the db and can be seen in plugins. Even if you changed something here, you have to do that again and everything will be loaded again in db. or else you can update in postman using other methods as well.
    @GetMapping("load")
    public String loadData() {
        service.load();
        return "load";
    }

}
