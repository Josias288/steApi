package com.tufergroupe.steapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tufergroupe.steapi.model.Soute;
import com.tufergroupe.steapi.model.Vehicule;
import com.tufergroupe.steapi.services.SouteService;
import com.tufergroupe.steapi.services.VehiculeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Servic;
import com.tufergroupe.steapi.services.ServiceService;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private SouteService souteService;
    @Autowired
    private VehiculeService vehiculeService;

    /**
     * Read - Get all societes
     * 
     * @return -
     */
    @GetMapping("/services")
    public Iterable<Servic> getServices() {
        return serviceService.getServices();
    }

    @RequestMapping(value = "/service/annee/{year}", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Servic> getServiceByYear(@PathVariable("year") int year) {
        return serviceService.findByYear(year);
    }

    @RequestMapping(value = "/service/date/{date}", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Servic> getServiceGraphique(
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return serviceService.graphiqueByDate(date);
    }

    @PostMapping("/service/save")
    public Servic saveService(@RequestBody Servic service) {
        Soute soute = service.getSoute();
        // Vehicule vehicule = service.getVehicule();
        int qtServie = service.getQuantiteServie();
        int qtSoute = Integer.parseInt(soute.getNiveauContenu());
        int newqtSoute = qtSoute - qtServie;
        soute.setNiveauContenu(String.valueOf(newqtSoute));
        // soute.addService(service);
        souteService.saveSoute(soute);
        // vehiculeService.saveVehicule(vehicule);

        return serviceService.saveService(service);
    }

    @GetMapping("/service/{id}")
    public Optional<Servic> getService(@PathVariable("id") final Long id) {
        return serviceService.getService(id);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable("id") final Long id) {
        serviceService.deleteService(id);
    }

    @PutMapping("/service/{id}")
    public Servic upkilometrageVehicule(@PathVariable("id") final Long id, @RequestBody Servic service) {
        Optional<Servic> e = serviceService.getService(id);
        if (e.isPresent()) {
            Servic currentService = e.get();

            String kilometrageVehicule = service.getKilometrageVehicule();
            if (kilometrageVehicule != null) {
                currentService.setKilometrageVehicule(kilometrageVehicule);
            }
            String nomChauffeur = service.getNomChauffeur();
            if (nomChauffeur != null) {
                currentService.setNomChauffeur(nomChauffeur);
                ;
            }
            String prenomChauffeur = service.getPrenomChauffeur();
            if (prenomChauffeur != null) {
                currentService.setPrenomChauffeur(prenomChauffeur);
                ;
            }
            String numeroChauffeur = service.getNumeroChauffeur();
            if (numeroChauffeur != null) {
                currentService.setNumeroChauffeur(numeroChauffeur);
            }
            String adresseChauffeur = service.getAdresseChauffeur();
            if (adresseChauffeur != null) {
                currentService.setAdresseChauffeur(adresseChauffeur);
                ;
            }
            String typeContenue = service.getTypeServie();
            if (typeContenue != null) {
                currentService.setTypeServie(typeContenue);
            }
            serviceService.saveService(currentService);
            return currentService;
        } else {
            return null;
        }
    }

}
