package com.example.citymanagement.service;

import com.example.citymanagement.model.City;
import com.example.citymanagement.model.Nation;

import java.util.List;

public interface CityService extends GeneralService<City>{
    City findByCityName(String name);
//    List<Nation> findAllNation();
}
