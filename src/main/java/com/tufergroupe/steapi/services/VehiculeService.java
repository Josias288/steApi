package com.tufergroupe.steapi.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.Vehicule;
import com.tufergroupe.steapi.repository.VehiculeRepository;

import lombok.Data;

@Data
@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Transactional(readOnly = true)
    public Optional<Vehicule> getVehicule(final Long id) {
        return vehiculeRepository.findById(id);
    }

    @Transactional(readOnly = true)
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
