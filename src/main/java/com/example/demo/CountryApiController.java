package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api")
public class CountryApiController {

    @Autowired
    CountryDatabaseService countryDatabaseService;

    @GetMapping("games")
    public Country getRandomCountry(){
        List<Country> countries = countryDatabaseService.findAllCountries();

        Random rand = new Random();
        Country randomCountry = countries.get(rand.nextInt(countries.size()));
        return randomCountry;
    }
}
