package com.cpe.backend.registercompany.controller;

import com.cpe.backend.registercompany.entity.Size;
import com.cpe.backend.registercompany.repository.SizeRepository;
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
public class SizeController {

    @Autowired
    private final SizeRepository sizeRepository;

    public SizeController(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @GetMapping("/size")
    public Collection<Size> Sizes() {
        return sizeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/size/{id}")
    public Optional<Size> Sizes(@PathVariable Long id) {
        Optional<Size> size = sizeRepository.findById(id);
        return size;
    }

}