package com.bootstrapwithspringboot.webapp.api;


import com.bootstrapwithspringboot.webapp.dao.ClasseMatiereDao;
import com.bootstrapwithspringboot.webapp.dto.ClasseMatiereDTO;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiere;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiereIdentity;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classematiere")
@AllArgsConstructor
public class ClasseMatiereCtrl {

//    private classeMatiereDao classeMatiereDao;
    private ClasseMatiereDao classeMatiereDao;

    private MatiereService matiereService;
    private ClasseService classeService;

    @PostMapping("/add")
    public ResponseEntity<ClasseMatiere> add(@Valid @RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{
            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
//            ClasseMatiere classeMatiere = new ClasseMatiere(classeMatiereDTO.getId(),classe,matiere);
            ClasseMatiere classeMatiere = new ClasseMatiere(new ClasseMatiereIdentity(classe,matiere));

            return new ResponseEntity(classeMatiereDao.save(classeMatiere), HttpStatus.OK);
        }
        catch( Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<ClasseMatiere>> getAll(){
        try {
            return new ResponseEntity(classeMatiereDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping({"/",""})
//    public List<ClasseMatiere> getAll(){
//            return classeMatiereDao.findAll();
//    }

    @GetMapping("/getOne")
    public ResponseEntity<ClasseMatiere> getOne(@RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{
            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
            ClasseMatiereIdentity id = new ClasseMatiereIdentity(classe,matiere);
            return new ResponseEntity(classeMatiereDao.getOne(id) , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  No need for update in this case*/
    /*@PutMapping("/update")
    public ResponseEntity<ClasseMatiere> update( @RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{
            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
//            ClasseMatiere classeMatiere = new ClasseMatiere(id,classe,matiere);
            ClasseMatiere classeMatiere = new ClasseMatiere(new ClasseMatiereIdentity(classe,matiere));

            return new ResponseEntity(classeMatiereDao.save(classeMatiere), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/




    @DeleteMapping({"/",""})
    public ResponseEntity<Void> delete(@RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{

            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
            ClasseMatiereIdentity id = new ClasseMatiereIdentity(classe,matiere);
            classeMatiereDao.delete(classeMatiereDao.getOne(id));
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byclasse/{id}")
    public List<ClasseMatiere> test(@PathVariable long  id){
        return classeMatiereDao.findByClasse(id);
    }
}
