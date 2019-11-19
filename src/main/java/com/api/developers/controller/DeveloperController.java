package com.api.developers.controller;

import com.api.developers.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DeveloperController {
    @Autowired
    DeveloperRepository developerRepository;

    @RequestMapping("/developers")
    public Map<String, Object> GetDevelopers() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("developers",developerRepository.findAll().stream().map(developer -> developer.makeDeveloperDTO()).collect(Collectors.toList()));

        return dto;
    }

    @RequestMapping("/developer/{id}")
    public Map<String, Object> GetDeveloper(@PathVariable Long id) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("developer",developerRepository.findById(id).map(developer -> developer.makeDeveloperDTO()));

        return dto;
    }


}
