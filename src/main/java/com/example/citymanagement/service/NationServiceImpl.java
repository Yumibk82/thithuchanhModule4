package com.example.citymanagement.service;

import com.example.citymanagement.model.Nation;
import com.example.citymanagement.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationServiceImpl implements NationService{
    @Autowired
    private NationRepository nationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return nationRepository.findById(id);
    }

    @Override
    public Page<Nation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Nation save(Nation nation) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
