package com.cpe.backend.resume.repository;

import com.cpe.backend.resume.entity.Resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ResumeRepository extends JpaRepository<Resume, Long> {
}




