package org.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank(message = "Name is mandatory")
    @Size( max = 50, message = "Name should not exceed 50 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Adresse is mandatory")
    private String adresse;

    @NotBlank(message = "Date of birthday is required")
    private String dateOfBirth;

    @NotBlank(message = "Register date is required")
    private String registerDate;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
