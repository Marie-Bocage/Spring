package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service //(Nécessaire pour utiliser Autowired)
public class AnnuaireService {

    private ArrayList<Personne> personnes = new ArrayList<>();
    private int nextId = 0;
    public void addPersonne(Personne personne){
        nextId++;
        personne.setId(nextId);
        personnes.add(personne);
    }

    public ArrayList<Personne> getPersonnes(){
        return personnes;
    }

    public Personne getOnePersonne(Integer id){
        for(Personne personne : personnes){
            if(personne.getId() == id) {
                return personne;
            }
        }
        return null;
    }

    public void delete(Integer id){
        Iterator<Personne> it = personnes.iterator();

        while(it.hasNext()){
            Personne p = it.next();
            if(p.getId().equals(id)){
                it.remove();
            }
        }
    }

    public void update(Personne p, Integer id){
        for(Personne personne : personnes) {
            if (personne.getId() == id) {
                personne.setNom(p.getNom());
                personne.setPrenom(p.getPrenom());
            }
        }
    }
}
