package com.cpe.backend.interview.repository;

import com.cpe.backend.interview.entity.InterviewAppointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface InterviewAppointmentRepository extends JpaRepository<InterviewAppointment, Long> {
   
}