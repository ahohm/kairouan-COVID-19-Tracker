package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, String> {
    Optional<Etudiant> findByMatricule(String matricule);
    List<Etudiant> findAllByClasse(Classe classe);
    @Query(value = "select max(matricule) from Etudiant ")
    String getMaxMatricule();


}
