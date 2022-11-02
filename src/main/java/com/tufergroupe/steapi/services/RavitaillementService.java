package com.tufergroupe.steapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.Ravitaillement;
import com.tufergroupe.steapi.repository.RavitaillementRepository;

import lombok.*;

@Data
@Service

public class RavitaillementService {
    @Autowired
    private RavitaillementRepository ravitaillementRepository;

    @Transactional(readOnly = true)
    public Optional<Ravitaillement> getRavitaillement(final Long id) {
        return ravitaillementRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Ravitaillement> getRavitaillements() {
        return ravitaillementRepository.findAll();
    }

    public void deleteRavitaillement(final Long id) {
        ravitaillementRepository.deleteById(id);
    }

    public Ravitaillement saveRavitaillement(Ravitaillement ravitaillement) {
        Ravitaillement savedRavitaillement = ravitaillementRepository.save(ravitaillement);
        return savedRavitaillement;
    }

    @Transactional(readOnly = true)
    public List<Ravitaillement> findByYear(int date) {
        return ravitaillementRepository.findByYear(date);
    }

    @Transactional(readOnly = true)
    public List<Ravitaillement> graphiqueByDate(Date date) {
        return ravitaillementRepository.graphiqueByDate(date);
    }
}
