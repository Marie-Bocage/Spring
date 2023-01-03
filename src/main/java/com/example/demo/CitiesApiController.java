package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
