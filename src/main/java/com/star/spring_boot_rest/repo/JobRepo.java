package com.star.spring_boot_rest.repo;

import com.star.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost (1, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
            new JobPost (2, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
            new JobPost (3, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
            new JobPost (4, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
            new JobPost (5, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate"))
    ));

    //This is just getting all jobs that are posted.
    public List<JobPost> getAllJobs(){
        return jobs;
    }

    //Basically this is saying to add this upcoming job from user to the upper list jobs we have created.
    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int postId) {

        for(JobPost job : jobs) {
            if(job.getPostId() == postId) {
                return job;
            }
        }

        return null;
    }
}
