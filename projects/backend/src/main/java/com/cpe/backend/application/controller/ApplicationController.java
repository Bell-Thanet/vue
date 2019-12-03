package com.cpe.backend.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.application.entity.Application;
import com.cpe.backend.application.repository.ApplicationRepository;
import com.cpe.backend.application.entity.Source;
import com.cpe.backend.application.repository.SourceRepository;

import com.cpe.backend.registeruser.entity.User;
import com.cpe.backend.registeruser.repository.UserRepository;
import com.cpe.backend.jobpost.entity.JobPost;
import com.cpe.backend.jobpost.repository.JobPostRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ApplicationController {
    @Autowired
    private final ApplicationRepository applicationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobPostRepository jobPostRepository;
    @Autowired
    private SourceRepository sourceRepository;

    ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/Application")
    public Collection<Application> Applications() {
        return applicationRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Application/{User_id}/{cardId}/{JobPost_id}/{introduction}/{Source_id}")
    public Application newApplication(@PathVariable long cardId, @PathVariable String introduction,
        @PathVariable long User_id, @PathVariable long JobPost_id, @PathVariable long Source_id) {
        Application newApplication = new Application();
        User user = userRepository.findById(User_id);
        JobPost post = jobPostRepository.findById(JobPost_id);
        Source sourceType = sourceRepository.findById(Source_id);

        newApplication.setUser(user);
        newApplication.setJobPost(post);
        newApplication.setSource(sourceType);
        newApplication.setCardId(cardId);
        newApplication.setIntroduction(introduction);

        return applicationRepository.save(newApplication);
    }
}