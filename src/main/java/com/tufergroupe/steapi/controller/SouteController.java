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
    public Soute saveSoute(@RequestBody Soute soute) {
        return souteService.saveSoute(soute);
    }

    @GetMapping("/soute/{id}")
    public Optional<Soute> getSoute(@PathVariable("id") final Long id) {
        return souteService.getSoute(id);
    }

    @DeleteMapping("/soute/{id}")
    public void deleteSoute(@PathVariable("id") final Long id) {
        souteService.deleteSoute(id);
    }

    @PutMapping("/soute/{id}")
    public Soute updateSoute(@PathVariable("id") final Long id, @RequestBody Soute soute) {
        Optional<Soute> e = souteService.getSoute(id);
        if (e.isPresent()) {
            Soute currentSoute = e.get();

            String codeS = soute.getCodeS();
            if (codeS != null) {
                currentSoute.setCodeS(codeS);
            }
            String typeContenue = soute.getTypeContenue();
            if (typeContenue != null) {
                currentSoute.setTypeContenue(typeContenue);
            }
            String niveauContenu = soute.getNiveauContenu();
            if (typeContenue != null) {
                currentSoute.setNiveauContenu(niveauContenu);
            }

            souteService.saveSoute(currentSoute);
            return currentSoute;
        } else {
            return null;
        }
    }
}
