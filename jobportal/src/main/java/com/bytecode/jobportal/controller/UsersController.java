package com.bytecode.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.entity.UsersType;
import com.bytecode.jobportal.services.UsersService;
import com.bytecode.jobportal.services.UsersTypeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		usersService.addNew(users);
		return "redirect:/dashboard";
	}	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication!=null) {
			new SecurityContextLogoutHandler().logout(request,response,authentication);
		}
		return "redirect:/";
		
	}
	
}