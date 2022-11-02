package com.tufergroupe.steapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tufergroupe.steapi.model.Soute;
import com.tufergroupe.steapi.services.SouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tufergroupe.steapi.model.Ravitaillement;
import com.tufergroupe.steapi.services.RavitaillementService;

@RestController
public class RavitaillementController {
    @Autowired
    private RavitaillementService ravitaillementService;
    @Autowired
    private SouteService souteService;

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
    public Ravitaillement saveRavitaillement(@RequestBody Ravitaillement ravitaillement) {
        Soute soute= ravitaillement.getSoute();
        int qtR=ravitaillement.getQuantiteFournie();
        int qtS= Integer.parseInt(soute.getNiveauContenu());
        int nqt=qtS+qtR;
        soute.setNiveauContenu(String.valueOf(nqt));
        souteService.saveSoute(soute);
        return ravitaillementService.saveRavitaillement(ravitaillement);
    }

    @GetMapping("/ravitaillement/{id}")
    public Optional<Ravitaillement> getRavitaillement(@PathVariable("id") final Long id) {
        return ravitaillementService.getRavitaillement(id);
    }

    @RequestMapping(value = "/ravitaillement/date/{date}", method = { RequestMethod.POST, RequestMethod.GET })
    public List<Ravitaillement> getRavitaillementGraphique(
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return ravitaillementService.graphiqueByDate(date);
    }

    @DeleteMapping("/ravitaillement/{id}")
    public void deleteRavitaillemnt(@PathVariable("id") final Long id) {
        ravitaillementService.deleteRavitaillement(id);
    }

    @PutMapping("/ravitaravitaillement/{id}")
    public Ravitaillement updateVehicule(@PathVariable("id") final Long id,
            @RequestBody Ravitaillement ravitaillement) {
        Optional<Ravitaillement> e = ravitaillementService.getRavitaillement(id);
        if (e.isPresent()) {
            Ravitaillement currentRavitaillement = e.get();

            String nomFournisseur = ravitaillement.getNomFournisseur();
            if (nomFournisseur != null) {
                currentRavitaillement.setNomFournisseur(nomFournisseur);
            }
            String adressFournisseur = ravitaillement.getAdressFournisseur();
            if (adressFournisseur != null) {
                currentRavitaillement.setAdressFournisseur(adressFournisseur);
            }
            int numFournisseur = ravitaillement.getNumFournisseur();
            if (numFournisseur != 0) {
                currentRavitaillement.setNumFournisseur(numFournisseur);
            }
            int quantiteFournie = ravitaillement.getQuantiteFournie();
            if (quantiteFournie != 0) {
                currentRavitaillement.setQuantiteFournie(quantiteFournie);
            }
            String typeFournie = ravitaillement.getTypeFournie();
            if (typeFournie != null) {
                currentRavitaillement.setTypeFournie(typeFournie);
            }

            ravitaillementService.saveRavitaillement(currentRavitaillement);
            return currentRavitaillement;
        } else {
            return null;
        }
    }
}
