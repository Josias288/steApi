package com.tufergroupe.steapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Soute;
import com.tufergroupe.steapi.services.SouteService;

@RestController
public class SouteController {
    @Autowired
    private SouteService souteService;

    /**
     * Read - Get all societes
     * 
     * @return -
     */
    @GetMapping("/soutes")
    public Iterable<Soute> getSoutes() {
        return souteService.getSoutes();
    }

    @PostMapping("/soute/save")
    public Soute saveSoute(Soute soute) {
        return souteService.saveSoute(soute);
    }

    @GetMapping("/soute/{id}")
    public Optional<Soute> getSoute(final Long id) {
        return souteService.getSoute(id);
    }

    @DeleteMapping("/soute/{id}")
    public void deleteSoute(final Long id) {
        souteService.deleteSoute(id);
    }
}
