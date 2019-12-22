package com.bootstrapwithspringboot.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDto {

    private long id;
    private String libel;
    private String nomComplet;
}
