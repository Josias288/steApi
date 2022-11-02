package com.tufergroupe.steapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tufergroupe.steapi.model.Servic;

public interface ServiceRepository extends CrudRepository<Servic, Long> {

    @Query(value = "SELECT * FROM service  WHERE YEAR(date_service) =?", nativeQuery = true)
    public List<Servic> findByYear(int year);

    @Query(value = "SELECT * FROM service  WHERE date_service =?", nativeQuery = true)
    public List<Servic> graphiqueByDate(Date date);
}
