package com.tufergroupe.steapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.Servic;
import com.tufergroupe.steapi.repository.ServiceRepository;

import lombok.Data;

@Data
@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Transactional(readOnly = true)
    public Optional<Servic> getService(final Long id) {
        return serviceRepository.findById(id);
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<Servic> findByYear(int year) {
        return serviceRepository.findByYear(year);
    }

    @Transactional(readOnly = true)
    public List<Servic> graphiqueByDate(Date date) {
        return serviceRepository.graphiqueByDate(date);
    }
}
