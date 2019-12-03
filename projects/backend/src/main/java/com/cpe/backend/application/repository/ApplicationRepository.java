package com.cpe.backend.application.repository;

import com.cpe.backend.application.entity.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findById(long id);
}