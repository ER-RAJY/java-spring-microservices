package org.pm.patientservice.service;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.dto.PatientRequestDTO;
import org.pm.patientservice.exception.EmailAlreadyExistsException;
import org.pm.patientservice.exception.PatientNotFoundException;
import org.pm.patientservice.mapper.PatienMapper;
import org.pm.patientservice.model.Patient;
import org.pm.patientservice.repository.PatienRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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


    public PatienResponseDTO createPatien(PatientRequestDTO patientRequestDTO){
        if (patienRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDTO.getEmail());
        }
        Patient newPatient = patienRepository.save(PatienMapper.toEntity(patientRequestDTO));
        return PatienMapper.toDTO(newPatient);
    }

    public PatienResponseDTO updatePatien(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patienRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        existingPatient.setName(patientRequestDTO.getName());
        existingPatient.setEmail(patientRequestDTO.getEmail());
        existingPatient.setAdresse(patientRequestDTO.getAdresse());
        existingPatient.setDateOfBirth(patientRequestDTO.getDateOfBirth() != null ? LocalDate.parse(patientRequestDTO.getDateOfBirth()) : null);
        existingPatient.setDateOfRegester(patientRequestDTO.getRegisterDate() != null ? LocalDate.parse(patientRequestDTO.getRegisterDate()) : null);

        Patient updatedPatient = patienRepository.save(existingPatient);
        return PatienMapper.toDTO(updatedPatient);
    }

}
