package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryDatabaseService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> findAllCountries(){
        return countryRepository.findAll();
    }
}
