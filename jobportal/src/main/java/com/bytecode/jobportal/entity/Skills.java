package com.bytecode.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="skills")
public class Skills {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String experienceLevel;
	private String yearsOfEcperience;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="job_seeker_profile")
	private JobSeekerProfile jobSeekerProfile;

	public Skills() {
		
	}

	public Skills(int id, String name, String experienceLevel, String yearsOfEcperience,
			JobSeekerProfile jobSeekerProfile) {
		this.id = id;
		this.name = name;
		this.experienceLevel = experienceLevel;
		this.yearsOfEcperience = yearsOfEcperience;
		this.jobSeekerProfile = jobSeekerProfile;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getYearsOfEcperience() {
		return yearsOfEcperience;
	}

	public void setYearsOfEcperience(String yearsOfEcperience) {
		this.yearsOfEcperience = yearsOfEcperience;
	}

	public JobSeekerProfile getJobSeekerProfile() {
		return jobSeekerProfile;
	}

	public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
		this.jobSeekerProfile = jobSeekerProfile;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + ", experienceLevel=" + experienceLevel + ", yearsOfEcperience="
				+ yearsOfEcperience + ", jobSeekerProfile=" + jobSeekerProfile + "]";
	}
	
	
	
	
	
}
