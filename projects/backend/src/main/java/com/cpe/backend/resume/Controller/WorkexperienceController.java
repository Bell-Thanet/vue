package com.cpe.backend.resume.Controller;

import com.cpe.backend.resume.entity.Workexperience;
import com.cpe.backend.resume.repository.WorkexperienceRepository;
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
public class WorkexperienceController {

    @Autowired
    private final WorkexperienceRepository workexperienceRepository;

    public WorkexperienceController(WorkexperienceRepository workexperienceRepository) {
        this.workexperienceRepository = workexperienceRepository;
    }

    @GetMapping("/workexperience")
    public Collection<Workexperience> Workexperiences() {
        return workexperienceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/workexperience/{id}")
    public Optional<Workexperience> Workexperiences(@PathVariable Long id) {
        Optional<Workexperience> workexperience = workexperienceRepository.findById(id);
        return workexperience;
    }

}