package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
