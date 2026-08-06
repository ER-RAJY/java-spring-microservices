package org.pm.patientservice.mapper;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.dto.PatientRequestDTO;
import org.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatienMapper {
    public static PatienResponseDTO toDTO(Patient patient){
        PatienResponseDTO pateinDTO = new PatienResponseDTO();
        pateinDTO.setId(patient.getId().toString());
        pateinDTO.setName(patient.getName());
        pateinDTO.setEmail(patient.getEmail());
        pateinDTO.setAdresse(patient.getAdresse());
        pateinDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return pateinDTO;
    }
    public static Patient toEntity(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAdresse(patientRequestDTO.getAdresse());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setDateOfRegester(LocalDate.parse(patientRequestDTO.getRegisterDate()));
        return patient;
    }
}
