package com.bootstrapwithspringboot.webapp.service;

import com.bootstrapwithspringboot.webapp.dao.ClasseDao;
import com.bootstrapwithspringboot.webapp.model.Classe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClasseService {

    private ClasseDao classeDao;

    public Classe save(Classe classe){
        return classeDao.save(classe);
    }

    public List<Classe> findAll(){
        return classeDao.findAll();
    }

    public Optional<Classe> getOneById(long id){
        return classeDao.findById(id);
    }
    public Classe getOne(long id){
        return classeDao.getOne(id);
    }

    public Classe update(long id, Classe classe){
        return classeDao.save(classe);
    }

    public void delete(long id){
        Classe etudiant = getOneById(id).get();
        classeDao.delete(etudiant);
    }

}
