package com.cpe.backend.registeruser.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import com.cpe.backend.registeruser.entity.Gender;
import com.cpe.backend.registeruser.entity.NameType;
import com.cpe.backend.registeruser.entity.PhoneType;
import com.cpe.backend.registeruser.entity.User;
import com.cpe.backend.registeruser.repository.GenderRepository;
import com.cpe.backend.registeruser.repository.NameTypeRepository;
import com.cpe.backend.registeruser.repository.PhoneTypeRepository;
import com.cpe.backend.registeruser.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class UserController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private NameTypeRepository nametypeRepository;
    @Autowired
    private PhoneTypeRepository phonetypeRepository;
    @Autowired
    private GenderRepository genderRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/checkuser/{emails}/{passwords}")
    public Collection<User> getCheck(@PathVariable("emails") String email, @PathVariable("passwords") String password) {
        return userRepository.findCheck(email,password);
    }

    @GetMapping("/user")
    public Collection<User> Users() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
  
    @PostMapping("/User/{names}/{emails}/{passwords}/{phones}/{gender_id}/{nametype_id}/{phonetype_id}")
    public User newUser(User newUser,
    @PathVariable String names,
    @PathVariable String emails,
    @PathVariable String passwords,
    @PathVariable String phones,
    @PathVariable long gender_id,
    @PathVariable long nametype_id,
    @PathVariable long phonetype_id) {
    
    Gender gender = genderRepository.findById(gender_id);
    NameType nametype = nametypeRepository.findById(nametype_id);
    PhoneType phonetype = phonetypeRepository.findById(phonetype_id);

    newUser.setName(names);
    newUser.setEmail(emails);
    newUser.setPassword(passwords);
    newUser.setPhone(phones);
    newUser.setGender(gender);
    newUser.setNameType(nametype);
    newUser.setPhoneType(phonetype);
    newUser.setRegistertime(new Date());

    return userRepository.save(newUser);
    
    }
}