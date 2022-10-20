package com.tufergroupe.steapi.model;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "service")
public class Servic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne
    private Soute soute;

    private String kilometrageVehicule;

    private String typeContenue;

    private Date dateService;
    private String nomChauffeur;
    private String prenomChauffeur;
    private int numeroChauffeur;
    private String adresseChauffeur;
}