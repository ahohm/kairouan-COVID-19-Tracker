package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})/*bech ynajim intitializi pojo mil les classe eli fihom attrebut classe*/
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Size(min=3, max=30)
    private String libel;

    @Size(min=3, max=30)
    private String nomComplet;



}
