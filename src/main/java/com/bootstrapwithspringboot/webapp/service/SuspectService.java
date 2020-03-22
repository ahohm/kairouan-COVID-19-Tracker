package com.bootstrapwithspringboot.webapp.service;


import com.bootstrapwithspringboot.webapp.dao.SuspectDao;
import com.bootstrapwithspringboot.webapp.dto.SuspectDto;
import com.bootstrapwithspringboot.webapp.model.Suspect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class SuspectService {


    private SuspectDao suspectDao;

    public Suspect save(SuspectDto suspect){
        Suspect suspect1 = new Suspect();

        suspect1.setFirstName(suspect.getFirstName());
        suspect1.setLastName(suspect.getLastName());
        suspect1.setCountry(suspect.getCountry());
        suspect1.setCity(suspect.getCity());
        suspect1.setPhonenumber(suspect.getPhonenumber());
        suspect1.setDateIn(LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(suspect.getDateIn())));
        suspect1.setDateOut(LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(suspect.getDateIn())).plusDays(14));

        if (suspect.getParentSuspect()!=0) {
                suspect1.setParentSuspect(getOneById(suspect.getParentSuspect()).get());
        }

        return suspectDao.save(suspect1);
    }

    public Suspect saveSuspect(Suspect suspect) {
        return suspectDao.save(suspect);
    }

    public List<Suspect> findAll(){
        return suspectDao.findAll();
    }

    public Optional<Suspect> getOneById(long id){
        return suspectDao.findById(id);
    }

    public List<Suspect> findByPattern(String pattern){
        return suspectDao.findAllByFirstNameOrLastNameOrPhonenumberEquals(pattern, pattern, pattern);
    }

    public List<Suspect> findByDisciplin(){
        return suspectDao.findByDesciplineFalse();
    }

    public List<Suspect> findByDisciplinAndCity(String city){
        return suspectDao.findByDesciplineFalseAndCityEquals(city);
    }

    public List<Suspect> findByCity(String city){
        return suspectDao.findByCityEquals(city);
    }

    public Suspect update(long id, SuspectDto suspect){
        Suspect suspect1 = new Suspect();
        suspect1.setId(id);
        suspect1.setFirstName(suspect.getFirstName());
        suspect1.setLastName(suspect.getLastName());
        suspect1.setCountry(suspect.getCountry());
        suspect1.setCity(suspect.getCity());
        suspect1.setPhonenumber(suspect.getPhonenumber());
        suspect1.setDescipline(suspect.isDescipline());
        suspect1.setInfected(suspect.isInfected());
        suspect1.setDateIn(LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(suspect.getDateIn())));
        suspect1.setDateOut(LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(suspect.getDateIn())).plusDays(14));

        return  suspectDao.save(suspect1);
    }

    public void delete(long id){
        Suspect suspect = getOneById(id).get();
        suspectDao.delete(suspect);
    }

    public  List<Suspect> complete(){
        return suspectDao.findByDateOutBefore(LocalDate.now());
    }

    public  List<Suspect> notComplete(){
        return suspectDao.findByDateOutAfter(LocalDate.now());
    }


    public List<Suspect> findByNameAndLname(String name, String lname) {
        return suspectDao.findByFirstNameAndLastNameEquals(name,lname);
    }


}
