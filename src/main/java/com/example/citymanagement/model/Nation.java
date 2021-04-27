package com.example.citymanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nationId;
    private String nationName;

}
