package com.bootstrapwithspringboot.webapp.api;


import com.bootstrapwithspringboot.webapp.dto.ClasseMatiereDTO;
import com.bootstrapwithspringboot.webapp.model.Classe;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiere;
import com.bootstrapwithspringboot.webapp.model.ClasseMatiereIdentity;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.ClasseService;
import com.bootstrapwithspringboot.webapp.service.ClassematiereService;
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

    private ClassematiereService classeMatiereService;

    private MatiereService matiereService;
    private ClasseService classeService;

    @PostMapping("/add")
    public ResponseEntity<ClasseMatiere> add(@Valid @RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{
            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
            ClasseMatiere classeMatiere = new ClasseMatiere(new ClasseMatiereIdentity(classe,matiere));

            return new ResponseEntity(classeMatiereService.save(classeMatiere), HttpStatus.OK);
        }
        catch( Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<ClasseMatiere>> getAll(){
        try {
            return new ResponseEntity(classeMatiereService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne")
    public ResponseEntity<ClasseMatiere> getOne(@RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{
            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
            ClasseMatiereIdentity id = new ClasseMatiereIdentity(classe,matiere);
            return new ResponseEntity(classeMatiereService.getOneById(id) , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping({"/",""})
    public ResponseEntity<Void> delete(@RequestBody ClasseMatiereDTO classeMatiereDTO){
        try{

            Classe classe = classeService.getOneById(classeMatiereDTO.getClasseid()).get();
            Matiere matiere = matiereService.getById(classeMatiereDTO.getMatiereid());
            ClasseMatiereIdentity id = new ClasseMatiereIdentity(classe,matiere);
            classeMatiereService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byclasse/{id}")
    public List<ClasseMatiere> test(@PathVariable long  id){
        return classeMatiereService.findAllByClasse(id);
    }
}
