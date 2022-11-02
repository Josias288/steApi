package com.tufergroupe.steapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.Soute;
import com.tufergroupe.steapi.repository.SouteRepository;

import lombok.Data;

@Data
@Service
public class SouteService {
    @Autowired
    private SouteRepository souteRepository;

    @Transactional(readOnly = true)
    public Optional<Soute> getSoute(final Long id) {
        return souteRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Soute> getSoutes() {
        return souteRepository.findAll();
    }

    public void deleteSoute(final Long id) {
        souteRepository.deleteById(id);
    }

    public Soute saveSoute(Soute soute) {
        Soute savedSoute = souteRepository.save(soute);
        return savedSoute;
    }

}