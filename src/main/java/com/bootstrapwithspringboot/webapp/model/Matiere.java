package com.bootstrapwithspringboot.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min=3, max=30)
    private String libel;

    @Positive
    private float numberHours;

    @Positive
    private long permit;

    //@OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private List<Abscence> abscences;

    //@OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
    private List<Elimination> eliminations;

    //@ManyToMany(cascade = CascadeType.DETACH)
    @ManyToMany()
    @JoinTable(name = "MATIERE_CLASSE",
            joinColumns = @JoinColumn(name = "MATIERE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLASSE_ID"))
    private List<Classe> classes;



    public Matiere(String libel, float numberHours, long permit) {
        this.libel = libel;
        this.numberHours = numberHours;
        this.permit = permit;
    }

    public Matiere(long id, String libel, float numberHours, long permit) {
        this.libel = libel;
        this.numberHours = numberHours;
        this.permit = permit;
    }

    public Matiere() {
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", libel='" + libel + '\'' +
                ", numberHours=" + numberHours +
                ", permit=" + permit +
                ", abscences=" + abscences +
                ", eliminations=" + eliminations +
                ", classes=" + classes +
                '}';
    }
}
