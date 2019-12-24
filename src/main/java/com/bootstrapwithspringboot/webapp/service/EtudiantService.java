package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.ClasseDao;
import com.bootstrapwithspringboot.webapp.dao.EtudiantDao;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService {

    private EtudiantDao etudiantDao;
    private ClasseDao classeDao;

    public Etudiant save(Etudiant etudiant){
        return etudiantDao.save(etudiant);
    }

    public List<Etudiant> findAll(){
        return etudiantDao.findAll();
    }

    public Etudiant getOneById(String matricule){
        return etudiantDao.findByMatricule(matricule);
    }

    public Etudiant update(Etudiant etudiant){
        return this.save(etudiant);
    }

    public boolean delete(String matricule){
        Etudiant etudiant = getOneById(matricule);
        try {
            etudiantDao.delete(etudiant);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Etudiant> findAllByClasse(long id){
        Classe c = classeDao.getOne(id);
        return etudiantDao.findAllByClasse(c);
    }

    public String maxMatricule(){
        return etudiantDao.getMaxMatricule();
    }

}
