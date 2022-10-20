package com.tufergroupe.steapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Servic;
import com.tufergroupe.steapi.services.ServiceService;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
     * Read - Get all societes
     * 
     * @return -
     */
    @GetMapping("/services")
    public Iterable<Servic> getServices() {
        return serviceService.getServices();
    }

    @PostMapping("/service/save")
    public Servic saveService(Servic service) {
        return serviceService.saveService(service);
    }

    @GetMapping("/service/{id}")
    public Optional<Servic> getService(final Long id) {
        return serviceService.getService(id);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(final Long id) {
        serviceService.deleteService(id);
    }
}
