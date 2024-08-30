package com.bytecode.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.repository.UsersRepository;

@Service
public class UsersService {
	private final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		return usersRepository.save(users);
	}

	public Optional<Users> getUserByEmail(String email){
		return usersRepository.findByEmail(email);
	}
	
}
