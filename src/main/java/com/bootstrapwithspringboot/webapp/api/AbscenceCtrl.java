package com.bootstrapwithspringboot.webapp.api;

import com.bootstrapwithspringboot.webapp.dto.AbscenceDTO;
import com.bootstrapwithspringboot.webapp.model.Abscence;
import com.bootstrapwithspringboot.webapp.model.Etudiant;
import com.bootstrapwithspringboot.webapp.model.Matiere;
import com.bootstrapwithspringboot.webapp.service.AbscenceService;
import com.bootstrapwithspringboot.webapp.service.EtudiantService;
import com.bootstrapwithspringboot.webapp.service.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/abscence")
@AllArgsConstructor
public class AbscenceCtrl {

    private AbscenceService abscenceService;
    private EtudiantService etudiantService;
    private MatiereService matiereService;

    @PostMapping("/add")
    public ResponseEntity<Abscence> add(@Valid @RequestBody AbscenceDTO abscenceDTO){
        try{
            Etudiant etudiant = etudiantService.getOneById(abscenceDTO.getEtudiantid());
            Matiere matiere = matiereService.getById(abscenceDTO.getMatiereid());
            Abscence abscence = new Abscence(abscenceDTO.getId(),etudiant,matiere, LocalDate.now());
            return new ResponseEntity(abscenceService.save(abscence), HttpStatus.OK);
        }
        catch( Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Abscence>> getAll(){
        try {
            return new ResponseEntity(abscenceService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abscence> getOne(@PathVariable long id){
        try{
            return new ResponseEntity(abscenceService.getOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abscence> update(@PathVariable long id, @RequestBody AbscenceDTO abscenceDTO){
        try{
            Etudiant etudiant = etudiantService.getOneById(abscenceDTO.getEtudiantid());
            Matiere matiere = matiereService.getById(abscenceDTO.getMatiereid());
            LocalDate date = LocalDate.parse(abscenceDTO.getDate());
            Abscence abscence = new Abscence(id,etudiant,matiere, date);
            return new ResponseEntity(abscenceService.update(abscence), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        try{
            abscenceService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
