package com.tufergroupe.steapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Vehicule;
import com.tufergroupe.steapi.services.VehiculeService;

@RestController
public class VehiculeController {
    @Autowired
    private VehiculeService vehiculeService;

    /**
     * Read - Get all societes
     * 
     * @return -
     */
    @GetMapping("/vehicules")
    public Iterable<Vehicule> getVehicules() {
        return vehiculeService.getVehicules();
    }

    @PostMapping("/vehicule/save")
    public Vehicule saveVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.saveVehicule(vehicule);
    }

    @GetMapping("/vehicule/{id}")
    public Optional<Vehicule> getVehicule(@PathVariable("id") final Long id) {
        return vehiculeService.getVehicule(id);
    }

    @DeleteMapping("/vehicule/{id}")
    public void deleteVehicule(@PathVariable("id") final Long id) {
        vehiculeService.deleteVehicule(id);
    }

    @PutMapping("/vehicule/{id}")
    public Vehicule updateVehicule(@PathVariable("id") final Long id, @RequestBody Vehicule vehicule) {
        Optional<Vehicule> e = vehiculeService.getVehicule(id);
        if (e.isPresent()) {
            Vehicule currentVehicule = e.get();

            String marque = vehicule.getMarque();
            if (marque != null) {
                currentVehicule.setMarque(marque);
            }
            String numeroImm = vehicule.getNumeroImm();
            if (numeroImm != null) {
                currentVehicule.setNumeroImm(numeroImm);
            }
            String type = vehicule.getType();
            if (type != null) {
                currentVehicule.setType(type);
            }

            vehiculeService.saveVehicule(currentVehicule);
            return currentVehicule;
        } else {
            return null;
        }
    }

}