package com.example.xacompetenze.repositories;

import com.example.xacompetenze.models.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "patrimonio", path = "patrimonio")
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
    Patrimonio findByName(@Param("name") String name);
    List<Patrimonio> findByValue(@Param("valore") long value);
    List<Patrimonio> findByAnnoCreazione(@Param("annoCreazione") Integer annoCreazione);
    void deleteByName(String name);
    Patrimonio findById(long id);
}
