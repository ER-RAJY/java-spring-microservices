package org.pm.patientservice.mapper;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.model.Patient;

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
}
