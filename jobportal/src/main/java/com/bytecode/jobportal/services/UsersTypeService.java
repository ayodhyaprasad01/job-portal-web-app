package com.bytecode.jobportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bytecode.jobportal.entity.UsersType;
import com.bytecode.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	private final UsersTypeRepository usersTypeRepository;
	
	public UsersTypeService(UsersTypeRepository usersTypeRepository) {
		this.usersTypeRepository=usersTypeRepository;
	}
	
	public List<UsersType> getAll(){
		return usersTypeRepository.findAll();
	}
}

