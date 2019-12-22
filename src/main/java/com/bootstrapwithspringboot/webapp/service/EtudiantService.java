package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.ClasseDao;
import com.bootstrapwithspringboot.webapp.dao.EtudiantDao;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantService {

    private EtudiantDao etudiantDao;
    private ClasseDao classeDao;


    public Etudiant save(Etudiant etudiant, long classeid){

        Classe classe =  classeDao.getOne(classeid);
        etudiant.setClasse(classe);
        return etudiantDao.save(etudiant);
    }

    public List<Etudiant> findAll(){
        return etudiantDao.findAll();
    }

    public Optional<Etudiant> getOneById(String matricule){
        return etudiantDao.findByMatricule(matricule);
    }

    public Etudiant update(long classeid, Etudiant etudiant){

        return this.save(etudiant, classeid);
    }

    public boolean delete(String matricule){
        Etudiant etudiant = getOneById(matricule).get();
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
