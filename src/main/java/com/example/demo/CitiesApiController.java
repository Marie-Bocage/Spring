package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
