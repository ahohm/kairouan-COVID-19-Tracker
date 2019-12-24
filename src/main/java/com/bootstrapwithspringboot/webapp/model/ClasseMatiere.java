package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClasseMatiere {


    @EmbeddedId
    private ClasseMatiereIdentity classeMatiereIdentity;

   /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Classe classe;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Matiere matiere;
   */

}
