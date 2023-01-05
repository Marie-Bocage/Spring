package com.example.demo;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class DemoSessionController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    AnnuaireDatabaseService annuaireDatabaseService;

    @Autowired
    ChienDatabaseService chienDatabaseService;

    @PostMapping("session")
    public void writeSession(@RequestBody Personne personne) {
        httpSession.setAttribute("moi", personne);
    }

    @GetMapping("session")
    public Personne readSession() {
        Personne personne = (Personne)httpSession.getAttribute("moi");
        return personne;
    }

    @PostMapping("chien/{id}")
    public void newDog(@RequestBody Chien c, @PathVariable Integer id) {
        c.setMaitre(annuaireDatabaseService.getPersonneById(id).get());
        chienDatabaseService.addChien(c);
    }
}
