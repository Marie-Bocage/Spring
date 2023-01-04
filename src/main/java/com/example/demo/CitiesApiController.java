package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    // GET one city
    @GetMapping("villes/{id}")
    public ResponseEntity getOneCity(@PathVariable Integer id) {
        Optional<Cities> optional = citiesDatabaseService.getCityById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optional.get());
        }
    }

    // DELETE by id
    @DeleteMapping("villes/{id}")
    public ResponseEntity deleteCity(@PathVariable Integer id) {
        Optional<Cities> optional = citiesDatabaseService.getCityById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Cities city = optional.get();
            citiesDatabaseService.deleteById(city.getId());
            return ResponseEntity.ok().build();
        }
    }

    // Update by id
    @PutMapping("villes/{id}")
    public ResponseEntity updateCity(@PathVariable Integer id, @RequestBody Cities city) {
        Optional<Cities> optional = citiesDatabaseService.getCityById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (city.getId() != id) {
            return ResponseEntity.badRequest().build();
        } else {
            citiesDatabaseService.update(city);
            return ResponseEntity.ok().build();
        }
    }

    // Villes de + de 500 habitants
    @GetMapping("findcitizensnb")
    public List<Cities> findAllByCitizensNb(@RequestParam int citizensNb) {
        List<Cities> result = new ArrayList<>(){};
        for(Cities cities : citiesDatabaseService.getCities()) {
            if(cities.getCitizensNb() >= citizensNb) {
                result.add(cities);
            }
        }
        return result;
    }
}
