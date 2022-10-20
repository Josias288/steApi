package com.tufergroupe.steapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeService.saveVehicule(vehicule);
    }

    @GetMapping("/vehicule/{id}")
    public Optional<Vehicule> getVehicule(final Long id) {
        return vehiculeService.getVehicule(id);
    }

    @DeleteMapping("/vehicule/{id}")
    public void deleteVehicule(final Long id) {
        vehiculeService.deleteVehicule(id);
    }
}