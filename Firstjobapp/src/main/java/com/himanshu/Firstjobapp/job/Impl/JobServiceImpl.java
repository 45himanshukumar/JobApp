package com.himanshu.Firstjobapp.job.Impl;


import com.himanshu.Firstjobapp.job.Job;
import com.himanshu.Firstjobapp.job.JobRepository;
import com.himanshu.Firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> findAllJob() {
        List<Job> jobs= jobRepository.findAll();
        return jobs;
    }

    @Override
    public Job getById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean DeleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean UpdateJob(Long id,Job updatedJob) {
        Optional<Job> jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job= jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
