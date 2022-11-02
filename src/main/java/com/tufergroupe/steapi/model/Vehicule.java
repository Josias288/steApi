package com.tufergroupe.steapi.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval =
     * true, fetch = FetchType.LAZY)
     * private List<Servic> services = new ArrayList<>();
     */

    @Column(name = "numeroImm")
    private String numeroImm;

    private String type;

    private String marque;

    /*
     * public void addService(Servic service) {
     * services.add(service);
     * service.setVehicule(this);
     * }
     * 
     * public void removeService(Servic service) {
     * services.remove(service);
     * service.setVehicule(null);
     * }
     */

}
