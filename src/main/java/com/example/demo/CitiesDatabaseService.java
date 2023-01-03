package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesDatabaseService {

    @Autowired
    CitiesRepository citiesRepository;

    public void addCity(Cities city){
        citiesRepository.save(city);
    }

    public List<Cities> getCities(){
        return citiesRepository.findAll();
    }


}
