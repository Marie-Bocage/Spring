package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class DemoApiController {

    @Autowired
    AnnuaireDatabaseService annuaireDatabaseService;

    @PostMapping("personnes")
    public void createPersonne(@RequestBody Personne personne){
        annuaireDatabaseService.addPersonne(personne);
    }

    @GetMapping("personnes")
    public List<Personne> getAllPersonne(){
      return annuaireDatabaseService.getPersonnes();
    }

    @GetMapping("personnes/{id}")
    public ResponseEntity getOnePersonne(@PathVariable Integer id){
        Optional<Personne> optional = annuaireDatabaseService.getPersonneById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Personne personne = optional.get();
            return ResponseEntity.ok(personne);
        }
    }

    // findallbynom?nom=bond
    @GetMapping("findallbynom")
    public List<Personne> findAllByNom(@RequestParam String nom) {
        return annuaireDatabaseService.getPersonnesByNom(nom);
    }

    // findallbynomandprenom?nom=bond&prennom=james
    @GetMapping("findallbynomandprenom")
    public List<Personne> findAllByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        return annuaireDatabaseService.getPersonneByNomAndPrenom(nom, prenom);
    }

//    @Autowired //(injecte un objet dans une variable)
//    AnnuaireService annuaireService;// = new AnnuaireService();

//    @GetMapping("personnes")
//    public List<Personne> getAllPersonne(){
////        Personne p = new Personne("Alain", "Delon");
////        return p;
//        return annuaireService.getPersonnes();
//    }
//
//    @GetMapping("personnes/{id}")
//    public Personne getOnePersonne(@PathVariable Integer id){
//        return annuaireService.getOnePersonne(id);
//    }
//
//    @PostMapping("personnes")
//    public void createPersonne(@RequestBody Personne personne){
////        System.out.println(personne);
//        annuaireService.addPersonne(personne);
//    }

//    @PutMapping("")

//    @DeleteMapping("")
}
