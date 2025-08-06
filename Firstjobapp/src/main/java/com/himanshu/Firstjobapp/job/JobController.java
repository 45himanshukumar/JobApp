package com.himanshu.Firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        List<Job> jobs=  jobService.findAllJob();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job created successfully",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getById(@PathVariable Long id){
        Job job=  jobService.getById(id);
        if(job!=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> DeleteJob(@PathVariable Long id){
        boolean deleted = jobService.DeleteJob(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Job not found or could not be deleted", HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id,@RequestBody Job job) {
        boolean updated = jobService.UpdateJob(id, job);
        if (updated) {
            return  new ResponseEntity<>("job update successfully" +
                    "",HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
