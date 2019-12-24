package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.ClasseMatiereDao;
import com.bootstrapwithspringboot.webapp.dao.MatiereDao;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiere;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MatiereService {

    private MatiereDao matiereDao;
    private ClasseMatiereDao classeMatiereDao;

    public Matiere save(Matiere matiere){
        return matiereDao.save(matiere);
    }

    public List<Matiere> findAll(){
        return matiereDao.findAll();
    }

    public Optional<Matiere> getOneById(long id){
        return matiereDao.findById(id);
    }

    public Matiere getById(long id){
        return matiereDao.getOne(id);
    }

    public Matiere update(Matiere matiere){
        return matiereDao.save(matiere);
    }

    public void delete(long id){
        Matiere matiere = getOneById(id).get();
        matiereDao.delete(matiere);
    }
    public void delete(Matiere matiere){
        matiereDao.delete(matiere);
    }

    public List<Matiere> findByClasse(long classe){

        List matieres = new ArrayList();

        List<ClasseMatiere> classeMatiere = classeMatiereDao.findByClasse(classe);
        for (ClasseMatiere e: classeMatiere) {
            matieres.add(e.getClasseMatiereIdentity().getMatiere());
        }
        return matieres;
    }


}
