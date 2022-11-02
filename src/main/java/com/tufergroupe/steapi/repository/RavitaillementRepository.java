package com.tufergroupe.steapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tufergroupe.steapi.model.Ravitaillement;

public interface RavitaillementRepository extends CrudRepository<Ravitaillement, Long> {

    @Query(value = "SELECT * FROM ravitaillement r WHERE EXTRACT (YEAR FROM r.dateRavittailement) =?", nativeQuery = true)
    public List<Ravitaillement> findByYear(@Param("date") int year);

    @Query(value = "SELECT * FROM ravitaillement WHERE  date_Ravittailement =?", nativeQuery = true)
    public List<Ravitaillement> graphiqueByDate(Date date);

}
