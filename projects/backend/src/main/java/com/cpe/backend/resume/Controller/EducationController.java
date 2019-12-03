package com.cpe.backend.resume.Controller;

import com.cpe.backend.resume.entity.Education;
import com.cpe.backend.resume.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EducationController {

    @Autowired
    private final EducationRepository educationRepository;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping("/education")
    public Collection<Education> Educations() {
        return educationRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/education/{id}")
    public Optional<Education> Educations(@PathVariable Long id) {
        Optional<Education> education = educationRepository.findById(id);
        return education;
    }
}





