package com.cpe.backend.registeruser.controller;
import com.cpe.backend.registeruser.entity.NameType;
import com.cpe.backend.registeruser.repository.NameTypeRepository;
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
public class NameTypeController {
    @Autowired
    private final NameTypeRepository nametypeRepository;
    
    public NameTypeController(NameTypeRepository nametypeRepository) {
        this.nametypeRepository = nametypeRepository;
    }

    @GetMapping("/nametype")
    public Collection<NameType> NameTypes() {
        return nametypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/nametype/{id}")
    public Optional<NameType> NameTypes(@PathVariable Long id) {
        Optional<NameType> nametype = nametypeRepository.findById(id);
        return nametype;
    }
}