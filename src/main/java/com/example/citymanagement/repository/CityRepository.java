package com.example.citymanagement.repository;

import com.example.citymanagement.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long>{
    City findByCityName(String name);
}
