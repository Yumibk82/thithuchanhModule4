package com.example.citymanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface GeneralService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Page<T> findAll(Pageable pageable);
    T save(T t);
    void remove(Long id);
}
