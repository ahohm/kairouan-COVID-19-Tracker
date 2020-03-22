package com.bootstrapwithspringboot.webapp.dao;

import com.bootstrapwithspringboot.webapp.model.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SuspectDao extends JpaRepository<Suspect, Long> {


    List<Suspect> findAllByFirstNameOrLastNameOrPhonenumberEquals(String name, String lastname, String phone);

    List<Suspect> findByFirstNameAndLastNameEquals(String name, String lastname);

    List<Suspect> findByCityEquals(String city);

    List<Suspect> findByDesciplineFalse();

    List<Suspect> findByDesciplineFalseAndCityEquals(String city);


    List<Suspect> findByDateOutBefore(LocalDate todaty);

    List<Suspect> findByDateOutAfter(LocalDate todaty);


}
