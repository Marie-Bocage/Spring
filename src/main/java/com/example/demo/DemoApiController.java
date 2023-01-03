package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class DemoApiController {

    @Autowired //(injecte un objet dans une variable)
    AnnuaireService annuaireService;// = new AnnuaireService();

    @GetMapping("personnes")
    public List<Personne> getAllPersonne(){
//        Personne p = new Personne("Alain", "Delon");
//        return p;
        return annuaireService.getPersonnes();
    }

    @GetMapping("personnes/{id}")
    public Personne getOnePersonne(@PathVariable Integer id){
        return annuaireService.getOnePersonne(id);
    }

    @PostMapping("personnes")
    public void createPersonne(@RequestBody Personne personne){
//        System.out.println(personne);
        annuaireService.addPersonne(personne);
    }

//    @PutMapping("")

//    @DeleteMapping("")
}
