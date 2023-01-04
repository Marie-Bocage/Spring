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

    public Optional<Cities> getCityById(Integer id) {
        return citiesRepository.findById(id);
    }

    public void deleteById(Integer id) {
        citiesRepository.deleteById(id);
    }

    public void update(Cities city) {
        citiesRepository.save(city);
    }

    public List<Cities> getAllByCitizensNb(int citizensNb) {
        return citiesRepository.findAllByCitizensNb(citizensNb);
    }
}
