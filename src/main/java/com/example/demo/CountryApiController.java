package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api")
public class CountryApiController {

    @Autowired
    CountryDatabaseService countryDatabaseService;

    @GetMapping("games")
    public List<Country> getAllCountries(){
        return countryDatabaseService.findAllCountries();
    }
}
