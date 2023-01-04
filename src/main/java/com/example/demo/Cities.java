package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "villes")
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    private String country;

    private int citizensNb;

    public Cities() {
    }

    public Cities(Integer id, String city, String country, int citizensNb) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.citizensNb = citizensNb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCitizensNb() {
        return citizensNb;
    }

    public void setCitizensNb(int citizensNb) {
        this.citizensNb = citizensNb;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", citizensNb=" + citizensNb +
                '}';
    }
}
