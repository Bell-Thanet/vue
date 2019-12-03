package com.cpe.backend.jobpost.repository;

import java.util.Collection;

import com.cpe.backend.jobpost.entity.JobPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface JobPostRepository extends JpaRepository<JobPost, Long> {
    JobPost findById(long id);

}

//SELECT POSITION FROM JOBPOST,POSITION WHERE JOBPOST.POSITION_ID = POSITION.POSITION_ID
