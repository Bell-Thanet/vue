package com.cpe.backend.application.controller;

import com.cpe.backend.application.entity.Source;
import com.cpe.backend.application.repository.SourceRepository;
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
public class SourceController {

    @Autowired
    private final SourceRepository sourceRepository;

    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @GetMapping("/source")
    public Collection<Source> Sources() {
        return sourceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/source/{id}")
    public Optional<Source> Sources(@PathVariable Long id) {
        Optional<Source> sourceType = sourceRepository.findById(id);
        return sourceType;
    }

}