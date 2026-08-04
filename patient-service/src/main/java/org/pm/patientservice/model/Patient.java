package org.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotNull
    private String name;


    @NotNull
    @Column(unique = true)
    @Email
    private String email;


    @NotNull
    private String adresse;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @NotNull
    private LocalDate dateOfRegester;



}
