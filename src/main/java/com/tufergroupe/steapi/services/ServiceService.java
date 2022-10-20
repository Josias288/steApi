package com.tufergroupe.steapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tufergroupe.steapi.model.Servic;
import com.tufergroupe.steapi.repository.ServiceRepository;

import lombok.Data;

@Data
@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public Optional<Servic> getService(final Long id) {
        return serviceRepository.findById(id);
    }

    public Iterable<Servic> getServices() {
        return serviceRepository.findAll();
    }

    public void deleteService(final Long id) {
        serviceRepository.deleteById(id);
    }

    public Servic saveService(Servic service) {
        Servic savedService = serviceRepository.save(service);
        return savedService;
    }
}
