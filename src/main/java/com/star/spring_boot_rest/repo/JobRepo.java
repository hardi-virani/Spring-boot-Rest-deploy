package com.star.spring_boot_rest.repo;

import com.star.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);

}

//
//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//        new JobPost (1, "Java Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
//        new JobPost (2, "Python Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
//        new JobPost (3, "React Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
//        new JobPost (4, "Angular Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate")),
//        new JobPost (5, "Node Developer", "Must have good exp in core java", 2, List.of("core java", "j2EE", "SpringBoot", "Hibernate"))
//));
//
////This is just getting all jobs that are posted.
//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
////Basically this is saying to add this upcoming job from user to the upper list jobs we have created.
//public void addJob(JobPost job) {
//    jobs.add(job); //where this add came from?
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//
//    for(JobPost job : jobs) {
//        if(job.getPostId() == postId) {
//            return job;
//        }
//    }
//
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//
//    for(JobPost jobPost1 : jobs) {
//        if(jobPost1.getPostId() == jobPost.getPostId()) {
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//
//}
//
//public void deleteJob(int postId) {
//
//    for(JobPost jobPost : jobs) {
//        if(jobPost.getPostId() == postId) {
//            jobs.remove(jobPost);
//        }
//    }
//}