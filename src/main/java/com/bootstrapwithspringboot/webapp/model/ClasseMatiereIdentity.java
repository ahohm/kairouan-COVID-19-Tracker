package com.bootstrapwithspringboot.webapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClasseMatiereIdentity implements Serializable {



    @NotNull
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Classe classe;

    @NotNull
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Matiere matiere;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClasseMatiereIdentity that = (ClasseMatiereIdentity) o;

        if (!classe.equals(that.classe)) return false;
        return matiere.equals(that.matiere);
    }


}
