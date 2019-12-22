package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abscence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Etudiant etudiant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Matiere matiere;

    @JsonIgnore
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Classe classe; // mechi fibeli katebeha bel s lenna ok ok

    private LocalDate date;


    @Override
    public String toString() {
        return "Abscence{" +
                "id=" + id +
                ", etudiant=" + etudiant +
                ", matiere=" + matiere +
                ", classe=" + classe +
                ", date=" + date +
                '}';
    }
}
