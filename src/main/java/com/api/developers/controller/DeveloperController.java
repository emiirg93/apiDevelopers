package com.api.developers.controller;

import com.api.developers.model.Developer;
import com.api.developers.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

        dto.put("developers",developerRepository.findAll());

        return dto;
    }

    @RequestMapping("/developer/{id}")
    public ResponseEntity<Map<String, Object>> GetDeveloper(@PathVariable Long id) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        Developer developer = developerRepository.findById(id).orElse(null);

        if(developer != null){
            return new ResponseEntity<>(makeMap("developer",developer), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(makeMap("error","id inexistente"), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> editDeveloper(@RequestBody Developer developer) {

        Developer d = developerRepository.findById(developer.getId()).get();

        developerRepository.save(developer);
        return new ResponseEntity<>(makeMap("OK", "modificacion exitosa", "developer", d), HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteDeveloper(@PathVariable Long id) {

        Developer developer = developerRepository.findById(id).orElse(null);

        if(developer != null){
            developerRepository.deleteById(id);
            return new ResponseEntity<>(makeMap("OK","eliminado","developer",developer), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(makeMap("error","id inexistente"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addDeveloper(@RequestBody Developer developer) {

        developerRepository.save(developer);
        return new ResponseEntity<>(makeMap("OK", "developer creado", "developer", developer), HttpStatus.CREATED);
    }

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private Map<String, Object> makeMap(String key, Object value, String key2, Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        map.put(key2, o);
        return map;
    }
}
