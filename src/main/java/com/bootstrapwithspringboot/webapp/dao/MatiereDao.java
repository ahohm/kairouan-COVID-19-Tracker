package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereDao extends JpaRepository<Matiere, Long> {
}
