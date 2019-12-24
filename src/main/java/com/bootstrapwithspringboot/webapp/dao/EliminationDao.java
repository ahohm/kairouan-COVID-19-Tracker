package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Elimination;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EliminationDao extends JpaRepository<Elimination, Long> {

    List<Elimination> findAllByEtudiant(Etudiant etudiant);
}
