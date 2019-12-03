package com.cpe.backend.registercompany.controller;

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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;



import com.cpe.backend.registercompany.entity.Size;
import com.cpe.backend.registercompany.entity.Type;
import com.cpe.backend.registercompany.entity.Province;
import com.cpe.backend.registercompany.entity.Company;
import com.cpe.backend.registercompany.repository.SizeRepository;
import com.cpe.backend.registercompany.repository.TypeRepository;
import com.cpe.backend.registercompany.repository.ProvinceRepository;
import com.cpe.backend.registercompany.repository.CompanyRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class CompanyController {
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private SizeRepository sizeRepository;

    CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @GetMapping("/check/{email}/{pass}")
    public Collection<Company> getCheck(@PathVariable("email") String email,
                                      @PathVariable("pass") String pass) {
        return companyRepository.findCheck(email,pass);
    }
    @GetMapping("/company")
    public Collection<Company> Companys() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/Company/{name}/{email}/{pass}/{size_id}/{type_id}/{province_id}")
    public Company newCompany(Company newCompany,
   
    @PathVariable String name,
    @PathVariable String email,
    @PathVariable String pass,
    @PathVariable long size_id,
    @PathVariable long type_id,
    @PathVariable long province_id) {
   
    Size size = sizeRepository.findById(size_id);
    Type type = typeRepository.findById(type_id);
    Province province = provinceRepository.findById(province_id);
    
    newCompany.setType(type);
    newCompany.setSize(size);
    newCompany.setProvince(province);
    newCompany.setTimeRegister(new Date());
    newCompany.setName(name);
    newCompany.setEmail(email);
    newCompany.setPass(pass);
    
    return companyRepository.save(newCompany);
    
    }
}