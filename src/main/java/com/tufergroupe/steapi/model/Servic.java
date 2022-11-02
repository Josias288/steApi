package com.tufergroupe.steapi.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Entity
@Table(name = "service")
public class Servic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Servic() {
    }

    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne(fetch = FetchType.LAZY)
    private Soute soute;

    private String kilometrageVehicule;

    private String typeServie;
    private String quantiteServie;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateService")
    private Date dateService;

    @PrePersist
    private void onCreate() {
        dateService = new Date();
    }

    private String nomChauffeur;
    private String prenomChauffeur;
    private String numeroChauffeur;
    private String adresseChauffeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Soute getSoute() {
        return soute;
    }

    public void setSoute(Soute soute) {
        this.soute = soute;
    }

    public String getKilometrageVehicule() {
        return kilometrageVehicule;
    }

    public void setKilometrageVehicule(String kilometrageVehicule) {
        this.kilometrageVehicule = kilometrageVehicule;
    }

    public String getTypeServie() {
        return typeServie;
    }

    public void setTypeServie(String typeServie) {
        this.typeServie = typeServie;
    }

    public String getQuantiteServie() {
        return quantiteServie;
    }

    public void setQuantiteServie(String quantiteServie) {
        this.quantiteServie = quantiteServie;
    }

    public Date getDateService() {
        return dateService;
    }

    public void setDateService(Date dateService) {
        this.dateService = dateService;
    }

    public String getNomChauffeur() {
        return nomChauffeur;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    public String getPrenomChauffeur() {
        return prenomChauffeur;
    }

    public void setPrenomChauffeur(String prenomChauffeur) {
        this.prenomChauffeur = prenomChauffeur;
    }

    public String getNumeroChauffeur() {
        return numeroChauffeur;
    }

    public void setNumeroChauffeur(String numeroChauffeur) {
        this.numeroChauffeur = numeroChauffeur;
    }

    public String getAdresseChauffeur() {
        return adresseChauffeur;
    }

    public void setAdresseChauffeur(String adresseChauffeur) {
        this.adresseChauffeur = adresseChauffeur;
    }
}