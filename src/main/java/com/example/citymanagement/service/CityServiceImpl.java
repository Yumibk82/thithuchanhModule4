package com.example.citymanagement.service;

import com.example.citymanagement.model.City;
import com.example.citymanagement.model.Nation;
import com.example.citymanagement.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService{
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private CityRepository cityRepository;
    @Override
    public City findByCityName(String name) {
        return cityRepository.findByCityName(name) ;
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
//    @Override
//    public List<Nation> findAllNation(){
//        String query="Select c From Nation as c";
//        TypedQuery<Nation> query1= em.createQuery(query,Nation.class);
//        return query1.getResultList();
//    }
}
