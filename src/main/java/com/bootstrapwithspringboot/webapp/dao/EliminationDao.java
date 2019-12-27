package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Elimination;
import com.bootstrapwithspringboot.webapp.model.EliminationIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EliminationDao extends JpaRepository<Elimination, EliminationIdentity> {

    @Query(value = "SELECT * FROM ELIMINATION WHERE  ETUDIANT_MATRICULE = ?1", nativeQuery = true)
    List<Elimination> findByEtudiant(String matricule);

    Elimination findByEliminationIdentityEquals(EliminationIdentity eliminationIdentity);
}
