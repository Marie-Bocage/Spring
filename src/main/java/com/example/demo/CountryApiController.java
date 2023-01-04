package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class CountryApiController {

    @Autowired
    CountryDatabaseService countryDatabaseService;
}
