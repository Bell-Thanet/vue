package com.cpe.backend.interview.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.application.entity.Application;
import com.cpe.backend.registercompany.entity.Company;
import com.cpe.backend.registercompany.entity.Province;
import com.cpe.backend.interview.entity.InterviewAppointment;
import com.cpe.backend.application.repository.ApplicationRepository;
import com.cpe.backend.interview.repository.InterviewAppointmentRepository;
import com.cpe.backend.registercompany.repository.CompanyRepository;
import com.cpe.backend.registercompany.repository.ProvinceRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InterviewAppointmentController {
    @Autowired
    private final InterviewAppointmentRepository interviewAppointmentRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    InterviewAppointmentController(InterviewAppointmentRepository interviewAppointmentRepository) {
        this.interviewAppointmentRepository = interviewAppointmentRepository;
    }
    @GetMapping("/interview")
    public Collection<InterviewAppointment> Interview() {
        return interviewAppointmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/interview/{APPLICATION_ID}/{APPLICATION_ID}/{Company_ID}/{date}/{Province_ID}")
    public InterviewAppointment newVideoRental(InterviewAppointment newInterviewAppointment,
    @PathVariable long APPLICATION_ID,
    @PathVariable long Company_ID,
    @PathVariable Date date,
    @PathVariable long Province_ID){
    //Interview newInterview = new Interview();

    Application  application = applicationRepository.findById(APPLICATION_ID);
    Company company = companyRepository.findById(Company_ID);
    Province province = provinceRepository.findById(Province_ID); 

    newInterviewAppointment.setApplication(application);
    newInterviewAppointment.setCompany(company);
    newInterviewAppointment.setInterview(date);
    newInterviewAppointment.setProvince(province);


    return interviewAppointmentRepository.save(newInterviewAppointment); 
    
    }
}