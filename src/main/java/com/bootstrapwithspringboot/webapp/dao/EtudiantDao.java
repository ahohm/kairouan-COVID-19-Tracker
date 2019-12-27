package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, String> {
    Etudiant findByMatricule(String matricule);

    @Query(value = "select max(matricule) from etudiant " , nativeQuery = true)
    String getMaxMatricule();

    List<Etudiant> findAllByClasse(Classe classe);


}
