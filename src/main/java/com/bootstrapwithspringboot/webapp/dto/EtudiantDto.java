package com.bootstrapwithspringboot.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {

    private String matricule;

    private String nom;

    private String prenom;

    private String email;

    private String dateDeNaissance;

    private String phoneNumber;

    private long classe;
}
