package com.tufergroupe.steapi.model;

import lombok.*;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "vehicule")
    private Collection<Servic> service;

    @Column(name = "numeroImm")
    private String numeroImm;

    private String type;

    private String marque;

}
