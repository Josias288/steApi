package com.tufergroupe.steapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tufergroupe.steapi.model.Servic;

@Repository
public interface ServiceRepository extends JpaRepository<Servic, Long> {

    @Query(value = "SELECT SUM(quantite_servie) FROM service WHERE YEAR(date_service) =? GROUP BY vehicule_id,MONTH(date_service) ORDER BY MONTH(date_service)  ", nativeQuery = true)
    public List<Servic> findByYear(int year);

    @Query(value = "SELECT * FROM service  WHERE date_service =?", nativeQuery = true)
    public List<Servic> graphiqueByDate(Date date);

    @Query(value = "SELECT SUM(quantite_servie) FROM service  WHERE vehicule_id =?", nativeQuery = true)
    public Long getSumById(Long id);
}
