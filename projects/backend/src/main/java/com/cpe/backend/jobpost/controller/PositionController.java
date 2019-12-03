package com.cpe.backend.jobpost.controller;

import com.cpe.backend.jobpost.entity.Position;
import com.cpe.backend.jobpost.repository.PositionRepository;
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
public class PositionController {

    @Autowired
    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("/position")
    public Collection<Position> Positions() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/position/{id}")
    public Optional<Position> Positions(@PathVariable Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position;
    }

}