package com.bytecode.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytecode.jobportal.entity.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType,Integer> {

//	List<UsersType> findAll();

}
