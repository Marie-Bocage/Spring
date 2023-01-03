package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/api")
public class AdminController {

    @Autowired
    private AnnuaireService annuaireService;

    @DeleteMapping("personnes/{id}")
    public ResponseEntity deletePersonne(@PathVariable Integer id){
        Personne p = annuaireService.getOnePersonne(id);
        if(p == null){
            // Indiquer status code : 404
            return ResponseEntity.notFound().build();
        } else {
            annuaireService.delete(id);
            // Indiquer status code : 200
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("personnes/{id}")
    public void updatePersonne(@PathVariable Integer id, @RequestBody Personne personne){
        annuaireService.update(personne, id);
    }
}
