package com.cpe.backend.jobpost.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.jobpost.entity.Position;
import com.cpe.backend.jobpost.entity.Benefits;

import com.cpe.backend.jobpost.entity.JobPost;

import com.cpe.backend.jobpost.repository.PositionRepository;
import com.cpe.backend.registercompany.entity.Company;
import com.cpe.backend.registercompany.repository.CompanyRepository;
import com.cpe.backend.jobpost.repository.BenefitsRepository;
import com.cpe.backend.jobpost.repository.JobPostRepository;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class JobPostController {
    @Autowired
    private final JobPostRepository jobPostRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private BenefitsRepository benefitsRepository;

    JobPostController(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @GetMapping("/JobPost")
    public Collection<JobPost> JobPosts() {
        return jobPostRepository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping("/JobPost/{Company_id}/{position_id}/{educationlevel}/{salary}/{benefits_id}/{Other_details}")
    public JobPost newJobPost(JobPost newJobPost,
    @PathVariable String Other_details,
    @PathVariable String educationlevel,
    @PathVariable String salary,
    @PathVariable long benefits_id,
    @PathVariable long Company_id,
    @PathVariable long position_id)
    
    {
    //VideoRental newVideoRental = new VideoRental();


    Position position = positionRepository.findById(position_id);
    Company company = companyRepository.findById(Company_id);
    Benefits benefits = benefitsRepository.findById(benefits_id);


    newJobPost.setOther(Other_details);
    newJobPost.setEducationlevel(educationlevel);
    newJobPost.setSalary(salary);
    newJobPost.setBenefits(benefits);
    newJobPost.setCompany(company);
    newJobPost.setPosition(position);
    return jobPostRepository.save(newJobPost); //บันทึก Objcet ชื่อ VideoRental
    
    }
}