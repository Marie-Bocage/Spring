package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesDatabaseService {

    @Autowired
    CitiesRepository citiesRepository;

    public void addCity(Cities city){
        citiesRepository.save(city);
    }

}
