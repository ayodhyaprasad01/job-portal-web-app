package com.bytecode.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytecode.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>  {

	Optional<Users> findByEmail(String email);
}
