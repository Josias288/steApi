package com.tufergroupe.steapi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "soute")
public class Soute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @OneToMany(mappedBy = "soute", cascade = CascadeType.ALL, orphanRemoval =
     * true)
     * private List<Servic> services = new ArrayList<>();
     * 
     * @EqualsAndHashCode.Exclude
     * 
     * @ToString.Exclude
     * private List<Servic> services = new ArrayList<>();
     * 
     * @OneToMany(mappedBy = "soute", cascade = CascadeType.ALL, orphanRemoval =
     * true, fetch = FetchType.LAZY)
     * 
     * @EqualsAndHashCode.Exclude
     * 
     * @ToString.Exclude
     * private List<Ravitaillement> ravitaillements = new ArrayList<>();
     */

    private String codeS;
    private String niveauContenu;
    private String typeContenue;

    public Soute() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*
     * public List<Servic> getServices() {
     * return services;
     * }
     * 
     * public void setServices(List<Servic> services) {
     * this.services = services;
     * }
     */

    public String getCodeS() {
        return codeS;
    }

    public void setCodeS(String codeS) {
        this.codeS = codeS;
    }

    public String getNiveauContenu() {
        return niveauContenu;
    }

    public void setNiveauContenu(String niveauContenu) {
        this.niveauContenu = niveauContenu;
    }

    public String getTypeContenue() {
        return typeContenue;
    }

    public void setTypeContenue(String typeContenue) {
        this.typeContenue = typeContenue;
    }

    /*
     * public void addService(Servic service) {
     * services.add(service);
     * service.setSoute(this);
     * }
     * 
     * public void removeService(Servic service) {
     * services.remove(service);
     * service.setSoute(null);
     * }
     * 
     * public void addRavitaillement(Ravitaillement ravitaillement) {
     * ravitaillements.add(ravitaillement);
     * ravitaillement.setSoute(this);
     * }
     * 
     * public void removeRavitaillement(Ravitaillement ravitaillement) {
     * ravitaillements.remove(ravitaillement);
     * ravitaillement.setSoute(null);
     * }
     */

}
