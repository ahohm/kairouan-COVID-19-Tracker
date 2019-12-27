package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ETUDIANT")
public class Etudiant {

    @Id
    @NotNull(message = "Matricule is mandatory must have exactly 5 caracter")
    @Size(min = 5, max = 5)
    @Column(name = "MATRICULE")
    private String matricule;


    @NotBlank(message = "Name is mandatory")
    @Size(min=3, max=30)
    @Column(name = "NOM")
    private String nom;

    @NotBlank(message = "last name is mandatory")
    @Size(min=3, max=30)
    @Column(name = "PRENOM")
    private String prenom;

    @NotBlank(message = "last name is mandatory")
    @Email(message = "Email should be valid")
    @Column(name = "EMAIL")
    private String email;

    //    @Past(message = "date od birth must be a past date")
    @Column(name = "DATE_DE_NAISSANCE")
    private LocalDate dateDeNaissance;

    @Pattern(regexp = "(\\+216|00)[0-9]{8}")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CLASSE_ID")
    private Classe classe;


    public Etudiant() {
    }

    public Etudiant(@NotNull(message = "Matricule is mandatory must have exactly 5 caracter")
                    @Size(min = 5, max = 5) String matricule,
                    @NotBlank(message = "Name is mandatory")
                    @Size(min = 3, max = 30) String nom,
                    @NotBlank(message = "last name is mandatory")
                    @Size(min = 3, max = 30) String prenom,
                    @NotBlank(message = "last name is mandatory")
                    @Email(message = "Email should be valid") String email,
                    LocalDate dateDeNaissance,
                    @Pattern(regexp = "(\\+216|00)[0-9]{8}") String phoneNumber) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.phoneNumber = phoneNumber;
    }
}
