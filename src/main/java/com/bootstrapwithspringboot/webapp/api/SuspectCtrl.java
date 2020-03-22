package com.bootstrapwithspringboot.webapp.api;


import com.bootstrapwithspringboot.webapp.dto.SuspectDto;
import com.bootstrapwithspringboot.webapp.model.Suspect;
import com.bootstrapwithspringboot.webapp.service.SuspectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suspect")
@AllArgsConstructor
public class SuspectCtrl {

    private SuspectService suspectService;


    @PostMapping("/add")
    public Suspect add(@RequestBody SuspectDto suspect){
            return suspectService.save(suspect);
    }

    @GetMapping({"/",""})
    public ResponseEntity<List<Suspect>> getAll(){
        try {
            return new ResponseEntity(suspectService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suspect> getOne(@PathVariable long id){
        try{
            return new ResponseEntity(suspectService.getOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bypattern/{name}")
    public ResponseEntity<Suspect> getOneByNameOrlastName(@PathVariable String name){
        try{
            return new ResponseEntity(suspectService.findByPattern(name), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bypattern/{name}/{lname}")
    public ResponseEntity<Suspect> getOneByNameAndlastName(@PathVariable String name,@PathVariable String lname){
        try{
            return new ResponseEntity(suspectService.findByNameAndLname(name,lname), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notdescipline")
    public ResponseEntity<Suspect> getNotdescipline(){
        try{
            return new ResponseEntity(suspectService.findByDisciplin(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notdesciplinebycity")
    public ResponseEntity<Suspect> getNotdesciplineAndCity(@RequestParam(name = "city") String city){
        try{
            System.out.println(city);
            return new ResponseEntity(suspectService.findByDisciplinAndCity(city), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suspect> update(@PathVariable long id, @RequestBody SuspectDto suspect){
        try{

            return new ResponseEntity(suspectService.update(id,suspect), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/setinfected/{id}")
    public ResponseEntity<Suspect> setInfected(@PathVariable long id){
        try{
            Suspect suspect = suspectService.getOneById(id).get();
            suspect.setInfected(!suspect.isInfected());
            return new ResponseEntity(suspectService.saveSuspect(suspect), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/setDescipline/{id}")
    public ResponseEntity<Suspect> setDescipline(@PathVariable long id){
        try{
            Suspect suspect = suspectService.getOneById(id).get();
            suspect.setDescipline(!suspect.isDescipline());
            return new ResponseEntity(suspectService.saveSuspect(suspect), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        try{
            suspectService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/complete")
    public ResponseEntity<List<Suspect>> getAllComplete(){
        try {
            return new ResponseEntity(suspectService.complete(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/notcomplete")
    public ResponseEntity<List<Suspect>> getAllNotComplete(){
        try {
            return new ResponseEntity(suspectService.notComplete(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
