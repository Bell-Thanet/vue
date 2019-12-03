package com.cpe.backend.resume.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.resume.entity.Resume;
import com.cpe.backend.registeruser.entity.User;
import com.cpe.backend.resume.entity.Education;
import com.cpe.backend.registercompany.entity.Province;
import com.cpe.backend.resume.entity.Workexperience;
import com.cpe.backend.resume.repository.ResumeRepository;
import com.cpe.backend.registeruser.repository.UserRepository;
import com.cpe.backend.resume.repository.EducationRepository;
import com.cpe.backend.registercompany.repository.ProvinceRepository;
import com.cpe.backend.resume.repository.WorkexperienceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ResumeController {
    @Autowired
    private final ResumeRepository resumeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private WorkexperienceRepository workexperienceRepository;
    

    ResumeController(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @GetMapping("/resume")
    public Collection<Resume> Resumes() {
        return resumeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/resume/{user_id}/{address}/{date}/{interest}/{talent}/{university}/{workaddress}/{education_id}/{province_id}/{workexperience_id}")
    public Resume newResume(Resume newResume,
    @PathVariable long user_id,
    @PathVariable String address,
    @PathVariable Date date,
    @PathVariable String interest,
    @PathVariable String talent,
    @PathVariable String university,     
    @PathVariable String workaddress, 
    @PathVariable long education_id,
    @PathVariable long province_id,
    @PathVariable long workexperience_id) {
    
    User user = userRepository.findById(user_id);
    Education education = educationRepository.findById(education_id);
    Province province = provinceRepository.findById(province_id);
    Workexperience workexperience = workexperienceRepository.findById(workexperience_id);
    
    newResume.setUser(user);
    newResume.setEducation(education);
    newResume.setProvince(province);
    newResume.setWorkexperience(workexperience);
    newResume.setAddress(address);
    newResume.setBirthday(date);
    newResume.setInterest(interest);
    newResume.setTalent(talent);
    newResume.setUniversity(university);
    newResume.setWorkaddress(workaddress);

    return resumeRepository.save(newResume); 
    
    }
}



