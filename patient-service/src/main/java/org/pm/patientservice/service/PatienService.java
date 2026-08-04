package org.pm.patientservice.service;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.mapper.PatienMapper;
import org.pm.patientservice.model.Patient;
import org.pm.patientservice.repository.PatienRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatienService {
    private PatienRepository patienRepository;
    public PatienService(PatienRepository patienRepository) {
        this.patienRepository = patienRepository;
    }

    public List<PatienResponseDTO> getPatiens(){

        List<Patient> patients = patienRepository.findAll(); // get list of patiens as class
//        List<PatienResponseDTO> patienResponseDTOS = patients.stream() // now mapped the lis of classes pateint to list of dto classes by streams.
////                .map(patient -> PatienMapper.toDTO(patient)).toList(); normal logique
//                .map(PatienMapper::toDTO).toList(); // by lamda methode reference
        return patients.stream().map(PatienMapper::toDTO).toList();
    }

}
