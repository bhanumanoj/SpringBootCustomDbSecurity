package com.springboot.customdbsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.customdbsecurity.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	Optional<Users> findByName(String username);

}
