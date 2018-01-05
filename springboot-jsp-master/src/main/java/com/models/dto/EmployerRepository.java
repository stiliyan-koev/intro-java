package com.models.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	int findEmployerIdByUserId(int userId);

	Page<Employer> findEmployerIdByUserId(int userId, Pageable page);
}
