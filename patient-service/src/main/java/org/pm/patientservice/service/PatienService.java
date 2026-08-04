package org.pm.patientservice.service;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.model.Patient;
import org.pm.patientservice.repository.PatienRepository;

import java.util.List;

public class PatienService {
    private PatienRepository patienRepository;
    public PatienService(PatienRepository patienRepository) {
        this.patienRepository = patienRepository;
    }

    public List<PatienResponseDTO> getPatiens(){
        List<Patient> patients = patienRepository.findAll();
    }

}
