package com.star.spring_boot_rest.service;

import com.star.spring_boot_rest.model.JobPost;
import com.star.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired //Used Autowired here because, we don't have to create new object by us, spring does it for us. Eg: without autowired - private JobRepo = new Jobrepo();
    private JobRepo repo; //Created this so the Service and JobRepo can talk to eachother.

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }


    public JobPost getJob(int postId) {

        return repo.getJob(postId);
    }
}
