package com.cpe.backend.registeruser.controller;
import com.cpe.backend.registeruser.entity.PhoneType;
import com.cpe.backend.registeruser.repository.PhoneTypeRepository;
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
public class PhoneTypeController {
    @Autowired
    private final PhoneTypeRepository phonetypeRepository;

    public PhoneTypeController(PhoneTypeRepository phonetypeRepository) {
        this.phonetypeRepository = phonetypeRepository;
    }

    @GetMapping("/phonetype")
    public Collection<PhoneType> PhoneTypes() {
        return phonetypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/phonetype/{id}")
    public Optional<PhoneType> PhoneTypes(@PathVariable Long id) {
        Optional<PhoneType> phonetype = phonetypeRepository.findById(id);
        return phonetype;
    }

}