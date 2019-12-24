package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.ClasseMatiere;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiereIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseMatiereDao extends JpaRepository<ClasseMatiere, ClasseMatiereIdentity> {


////    @Query(value = "SELECT u FROM ClasseMatiere u where u.classe = ?1 ")
    @Query(value = "SELECT * FROM CLASSE_MATIERE WHERE CLASSE_ID = ?1", nativeQuery = true)
    List<ClasseMatiere> findByClasse(long classeid);

//    List<ClasseMatiere> findAllByClasse_IdMatiereIdentityClasse( Long id);

}
