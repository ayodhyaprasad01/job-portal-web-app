package com.bytecode.jobportal.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bytecode.jobportal.entity.JobPostActivity;
import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.services.JobPostActivityService;
import com.bytecode.jobportal.services.UsersService;

@Controller
public class JobPostActivityController {

	private final UsersService usersService;
	private final JobPostActivityService jobPostActivityService;

	@Autowired
	public JobPostActivityController(UsersService usersService,JobPostActivityService jobPostActivityService) {
		this.usersService = usersService;
		this.jobPostActivityService =jobPostActivityService;
	}
	
	@GetMapping("/dashboard/")
			public String searchJobs(Model model) {
		
		     Object currentUserProfile=usersService.getCurrentUserProfile();
		     Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		     
		     if(!(authentication instanceof AnonymousAuthenticationToken)) {
					String CurrentUsername=authentication.getName();
					model.addAttribute("username", CurrentUsername);
		     }
		     
		     model.addAttribute("user", currentUserProfile);
		     System.out.println("Dashboard");
				return "dashboard";
			}
	
	@GetMapping("/dashboard/add")
	public String addJobs(Model model) {
		model.addAttribute("jobPostActivity", new JobPostActivity());
		model.addAttribute("user", usersService.getCurrentUserProfile());
		return "add-jobs";
	}
	
	@PostMapping("/dashboard/addNew")
	public String addNew(JobPostActivity jobPostActivity,Model model) {
		Users user=usersService.getCurrentUser();
		if(user != null) {
			jobPostActivity.setPostedById(user);
		}
		jobPostActivity.setPostedDate(new Date());
		model.addAttribute("jobPostActivity", jobPostActivity);
		jobPostActivityService.addNew(jobPostActivity);
		return "redirect:/dashboard/";
	}
	

}
