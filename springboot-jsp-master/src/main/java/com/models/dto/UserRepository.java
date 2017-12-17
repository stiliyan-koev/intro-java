package com.models.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// List<User> findByLastName(String lastName);

	User findByAccountName(String accountName);
}
