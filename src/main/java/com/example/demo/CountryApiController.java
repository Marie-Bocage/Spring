package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @PostMapping("games/{id}")
    public ResponseEntity findRightCapital(@PathVariable Integer id, @RequestBody CapitalDto capital) {
        Optional<Country> optional = countryDatabaseService.findById(id);
        String response;

        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            if(optional.get().getCapital().equals(capital.getCapitalName()))  {
                response = "GAGNE !";
                return ResponseEntity.ok(response);
            }
            response = "PERDU, la réponse était : " + optional.get().getCapital();
            return ResponseEntity.ok(response);
        }
    }
}
