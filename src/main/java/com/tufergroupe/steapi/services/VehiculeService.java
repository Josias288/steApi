package com.tufergroupe.steapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tufergroupe.steapi.model.Vehicule;
import com.tufergroupe.steapi.repository.VehiculeRepository;

import lombok.Data;

@Data
@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Optional<Vehicule> getVehicule(final Long id) {
        return vehiculeRepository.findById(id);
    }

    public Iterable<Vehicule> getVehicules() {
        return vehiculeRepository.findAll();
    }

    public void deleteVehicule(final Long id) {
        vehiculeRepository.deleteById(id);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return savedVehicule;
    }

}
