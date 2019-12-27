package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.EliminationDao;
import com.bootstrapwithspringboot.webapp.model.Elimination;
import com.bootstrapwithspringboot.webapp.model.EliminationIdentity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EliminationService {

    private EliminationDao eliminationDao;

    public Elimination save(Elimination elimination){
        return eliminationDao.save(elimination);
    }

    public List<Elimination> findAll(){
        return eliminationDao.findAll();
    }

    public Elimination getOneById(EliminationIdentity id){
        return eliminationDao.findByEliminationIdentityEquals(id);
    }

    public Elimination update(Elimination classeMatiere){
        return this.save(classeMatiere);
    }

    public boolean delete(EliminationIdentity id){
        Elimination etudiant = getOneById(id);
        try {
            eliminationDao.delete(etudiant);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Elimination> findAllByEtudiant(String etudiantid){
        return eliminationDao.findByEtudiant(etudiantid);
    }
}
