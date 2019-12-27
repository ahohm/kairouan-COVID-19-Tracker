package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})/*bech ynajim intitializi pojo mil les classe eli fihom attrebut classe*/
@Table(name = "CLASSE")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "ID")
    private long id;

    @Size(min=3, max=30)
    @Column(name = "LIBEL")
    private String libel;

    @Size(min=3, max=30)
    @Column(name = "NOM_COMPLET")
    private String nomComplet;



}
