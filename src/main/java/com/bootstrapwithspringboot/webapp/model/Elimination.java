package com.bootstrapwithspringboot.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Elimination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etudiant etudiant;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Matiere matiere;

}
