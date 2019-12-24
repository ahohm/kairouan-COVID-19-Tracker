package com.bootstrapwithspringboot.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbscenceDTO {


    private long id;
    @Size(min = 5 , max = 5)
    private String etudiantid;
    private long matiereid;
    private String date;
}
