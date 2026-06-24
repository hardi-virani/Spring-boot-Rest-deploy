package com.star.spring_boot_rest.service;

import com.star.spring_boot_rest.model.JobPost;
import com.star.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {




    @Autowired //Used Autowired here because, we don't have to create new object by us, spring does it for us. Eg: without autowired - private JobRepo = new Jobrepo();
    private JobRepo repo; //Created this so the Service and JobRepo can talk to eachother.

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }


    public JobPost getJob(int postId) {

        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
         repo.save(jobPost);
    }

    public void deleteJob(int postId) {
         repo.deleteById(postId);
    }

    //to fetch the data in your database, you judt need to run the http://localhost:8080/load in postman And then this data will be loaded in the db and can be seen in plugins. Even if you changed something here, you have to do that again and everything will be loaded again in db. or else you can update in postman using other methods as well.
    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost (1, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
                new JobPost (2, "Python Developer", "Must have good exp in core Python", 2, List.of("core Python", "j2EE", "SpringBoot", "Hibernate")),
                new JobPost (3, "React Developer", "Must have good exp in core React", 2, List.of("core React", "j2EE", "SpringBoot", "Hibernate")),
                new JobPost (4, "Angular Developer", "Must have good exp in core Angular", 2, List.of("core Angular", "j2EE", "SpringBoot", "Hibernate")),
                new JobPost (5, "Node Developer", "Must have good exp in API Node", 2, List.of("core Node", "j2EE", "SpringBoot", "Hibernate"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
