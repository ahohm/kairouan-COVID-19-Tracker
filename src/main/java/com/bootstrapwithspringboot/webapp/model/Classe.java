package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Size(min=3, max=30)
    private String libel;

    @Size(min=3, max=30)
    private String nomComplet;

    @JsonIgnore//inti zedtha s oui ma4ir s hiya 5atir one classe min 4adi to many abscence min hne
    @OneToMany(mappedBy = "classe", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Abscence> abscences;

    @JsonIgnore
    @ManyToMany( mappedBy = "classes" , cascade = CascadeType.REMOVE)
    private List<Matiere> matieres;

    @JsonIgnore
    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Etudiant> etudiants;

    public Classe() {
    }


    public Classe(String libel, String nomComplet) {
        this.libel= libel;
        this.nomComplet=nomComplet;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "id=" + id +
                ", libel='" + libel + '\'' +
                ", nomComplet='" + nomComplet + '\'' +
                ", abscences=" + abscences +
                ", matieres=" + matieres +
                ", etudiants=" + etudiants +
                '}';
    }
}
