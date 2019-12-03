package com.cpe.backend.resume.repository;

import com.cpe.backend.resume.entity.Workexperience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface WorkexperienceRepository extends JpaRepository<Workexperience, Long> {
	Workexperience findById(long id);
}



