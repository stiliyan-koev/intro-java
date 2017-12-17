package com.models.dto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	int findEmployerIdByUserId(int userId);

}
