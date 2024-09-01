package com.bytecode.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytecode.jobportal.entity.JobPostActivity;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity,Integer> {

	JobPostActivity save(JobPostActivity jobPostActivity);
	
	
	
}
