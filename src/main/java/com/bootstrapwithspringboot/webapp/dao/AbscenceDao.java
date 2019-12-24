package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Abscence;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbscenceDao extends JpaRepository<Abscence, Long> {
    List<Abscence> findAllByMatiereAndEtudiant(Matiere matiere, Etudiant etudiant);

}
