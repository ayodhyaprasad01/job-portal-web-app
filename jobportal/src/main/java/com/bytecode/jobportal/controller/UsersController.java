package com.bytecode.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.entity.UsersType;
import com.bytecode.jobportal.services.UsersService;
import com.bytecode.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {
	
	private final UsersTypeService usersTypeSrvice;
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersTypeService usersTypeSrvice, UsersService usersService) {
		this.usersTypeSrvice = usersTypeSrvice;
		this.usersService = usersService;
		
	}

	
	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType>usersTypes=usersTypeSrvice.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());
		return "register";
	}
	
	@PostMapping("/register/new")
	public String userRegistration(@Valid Users users,Model model) {
		Optional<Users> optionalUsers=usersService.getUserByEmail(users.getEmail());
		
		if(optionalUsers.isPresent()) {
			model.addAttribute("error", "Email Already rigistered, try to login or register with other email.");
			List<UsersType>usersTypes=usersTypeSrvice.getAll();
			model.addAttribute("getAllTypes", usersTypes);
			model.addAttribute("user", new Users());
			return "register";
		}
//		System.out.println("Users::"+users);
		usersService.addNew(users);
		return "dashboard";
	}	
	
}