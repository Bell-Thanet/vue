package com.cpe.backend.jobpost.controller;

import com.cpe.backend.jobpost.entity.Benefits;
import com.cpe.backend.jobpost.repository.BenefitsRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BenefitsController {

    @Autowired
    private final BenefitsRepository benefitsRepository;

    public BenefitsController(BenefitsRepository benefitsRepository) {
        this.benefitsRepository = benefitsRepository;
    }

    @GetMapping("/benefits")
    public Collection<Benefits> Benefitss() {
        return benefitsRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/benefits/{id}")
    public Optional<Benefits> Benefitss(@PathVariable Long id) {
        Optional<Benefits> benefits = benefitsRepository.findById(id);
        return benefits;
    }

}