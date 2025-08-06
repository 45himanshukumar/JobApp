package com.himanshu.Firstjobapp.job;

import java.util.List;

public interface JobService {

    void createJob(Job job) ;

    List<Job> findAllJob();
    Job getById(Long id);
    boolean DeleteJob(Long id);
    boolean UpdateJob(Long id, Job updateJob);

}
