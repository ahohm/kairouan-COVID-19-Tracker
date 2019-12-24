package com.bootstrapwithspringboot.webapp.api;


import com.bootstrapwithspringboot.webapp.dto.EliminationDTO;
import com.bootstrapwithspringboot.webapp.model.Elimination;
import com.bootstrapwithspringboot.webapp.model.EliminationIdentity;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.EliminationService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/elimination")
@AllArgsConstructor
public class EliminationCtrl {

    private EliminationService eliminationService;

    private EtudiantService etudiantService;
    private MatiereService matiereService;

    @PostMapping("/add")
    public ResponseEntity<Elimination> add(@Valid @RequestBody EliminationDTO eliminationDTO){
        try{
            Etudiant etudiant = etudiantService.getOneById(eliminationDTO.getEtudiantid());
            Matiere matiere = matiereService.getById(eliminationDTO.getMatiereid());
//            ClasseMatiere classeMatiere = new ClasseMatiere(classeMatiereDTO.getId(),classe,matiere);
            Elimination elimination = new Elimination(new EliminationIdentity(etudiant,matiere));

            return new ResponseEntity(eliminationService.save(elimination), HttpStatus.OK);
        }
        catch( Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Elimination>> getAll(){
        try {
            return new ResponseEntity(eliminationService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping({"/",""})
//    public List<ClasseMatiere> getAll(){
//            return classeMatiereService.findAll();
//    }

    @GetMapping("/getOne")
    public ResponseEntity<Elimination> getOne(@RequestBody EliminationDTO eliminationDTO){
        try{
            Etudiant etudiant = etudiantService.getOneById(eliminationDTO.getEtudiantid());
            Matiere matiere = matiereService.getById(eliminationDTO.getMatiereid());
            EliminationIdentity id = new EliminationIdentity(etudiant,matiere);
//            return new ResponseEntity(classeMatiereService.getOne(id) , HttpStatus.OK);
            return new ResponseEntity(eliminationService.getOneById(id) , HttpStatus.OK);
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

            return new ResponseEntity(classeMatiereService.save(classeMatiere), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/




    @DeleteMapping({"/",""})
    public ResponseEntity<Void> delete(@RequestBody EliminationDTO eliminationDTO){
        try{

            Etudiant etudiant = etudiantService.getOneById(eliminationDTO.getEtudiantid());
            Matiere matiere = matiereService.getById(eliminationDTO.getMatiereid());
            EliminationIdentity id = new EliminationIdentity(etudiant,matiere);
            eliminationService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byetudiant/{id}")
    public ResponseEntity<List<Elimination>> getAllByEtudiant(@PathVariable String  id){

        try {
            return new ResponseEntity<>(eliminationService.findAllByEtudiant(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
