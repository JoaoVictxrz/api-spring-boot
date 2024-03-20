package com.portfolio.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
