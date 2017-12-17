package com.markovski.dto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	int findEmployerIdByUserId(int userId);

}
