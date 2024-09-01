package com.bytecode.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bytecode.jobportal.entity.Users;
import com.bytecode.jobportal.repository.UsersRepository;
import com.bytecode.jobportal.util.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UsersRepository  usersRepository;
	
	
	@Autowired
	public CustomUserDetailsService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{ 
		
		Users user=usersRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("not found user"));		
		return new CustomUserDetails(user);
	}

}
