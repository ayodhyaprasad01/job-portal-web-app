package com.bytecode.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecode.jobportal.entity.JobPostActivity;
import com.bytecode.jobportal.repository.JobPostActivityRepository;

@Service
public class JobPostActivityService {
	
	private final JobPostActivityRepository jobPostActivityRepository;
	
	

	@Autowired
	public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
		this.jobPostActivityRepository = jobPostActivityRepository;
	}



	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
		
		return jobPostActivityRepository.save(jobPostActivity);
		
	}
}
