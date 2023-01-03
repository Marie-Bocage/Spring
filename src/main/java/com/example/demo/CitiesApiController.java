package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CitiesApiController {

    @Autowired
    CitiesDatabaseService citiesDatabaseService;

    // POST
    @PostMapping("villes")
    public void createCity(@RequestBody Cities city) {
        citiesDatabaseService.addCity(city);
    }

    // GET all
    @GetMapping("villes")
    public List<Cities> getAllCities(){
        return citiesDatabaseService.getCities();
    }

    @GetMapping("villes/{id}")
    public ResponseEntity getOneCity(@PathVariable Integer id) {
        Optional<Cities> optional = citiesDatabaseService.getCityById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optional.get());
        }
    }
}
