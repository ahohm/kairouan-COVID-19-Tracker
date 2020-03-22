package com.bootstrapwithspringboot.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Suspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String phonenumber;

    private String country;
    private String city;


    private LocalDate dateIn;
    private LocalDate dateOut;

    private boolean descipline;
    private boolean isInfected;

    @OneToMany(cascade = CascadeType.DETACH)
    @JsonIgnore
    private List<Suspect> subSuspects;
    @ManyToOne
    private Suspect parentSuspect;



}
