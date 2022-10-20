package com.tufergroupe.steapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Ravitaillement;
import com.tufergroupe.steapi.services.RavitaillementService;

@RestController
public class RavitaillementController {
    @Autowired
    private RavitaillementService ravitaillementService;

    /**
     * Read - Get all societes
     * 
     * @return -
     */
    @GetMapping("/ravitaillements")
    public Iterable<Ravitaillement> getRavitaillements() {
        return ravitaillementService.getRavitaillements();
    }

    @PostMapping("/ravitaillement/save")
    public Ravitaillement saveRavitaillement(Ravitaillement ravitaillement) {
        return ravitaillementService.saveRavitaillement(ravitaillement);
    }

    @GetMapping("/ravitaillement/{id}")
    public Optional<Ravitaillement> getRavitaillement(final Long id) {
        return ravitaillementService.getRavitaillement(id);
    }

    @DeleteMapping("/ravitaillement/{id}")
    public void deleteRavitaillemnt(final Long id) {
        ravitaillementService.deleteRavitaillement(id);
    }
}
