package com.star.JobApp.service;

import com.star.JobApp.model.JobPost;
import com.star.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired //Used Autowired here because, we don't have to create new object by us, spring does it for us. Eg: without autowired - private JobRepo = new Jobrepo();
    private JobRepo service; //Created this so the Service and JobRepo can talk to eachother.

    public void addJob(JobPost jobPost) {
        service.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }


}
