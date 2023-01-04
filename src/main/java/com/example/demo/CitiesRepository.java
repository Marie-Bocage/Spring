package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {

    public List<Cities> CitizensNbGreaterThan(int citizensNb);
}
