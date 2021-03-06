package com.bridgelabz.fundoonotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundoonotes.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmailId(String emailId);
	
    User findById(int id);

	}

