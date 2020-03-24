package com.bootstrapwithspringboot.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuspectDtoNested {

    private long id;

    private String firstName;

    private String lastName;

    private String phonenumber;

    private String country;

    private String city;

    @Size(min=10, max=10)
    private String dateIn;

    private long parentSuspect;

    private boolean descipline;
    private boolean infected;
}
