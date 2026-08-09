package org.pm.patientservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.hibernate.boot.model.internal.XMLContext;
import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.dto.PatientRequestDTO;
import org.pm.patientservice.dto.validator.UpdatePatientValidationGroup;
import org.pm.patientservice.repository.PatienRepository;
import org.pm.patientservice.service.PatienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Controller", description = "API for managing patients")
public class PatienController {
    private final PatienService  patienService;
    public PatienController(PatienService patienService) {
        this.patienService = patienService;
    }

    @GetMapping
    @Operation(summary = "Get all patients", description = "Retrieve a list of all patients")
    public ResponseEntity<List<PatienResponseDTO>> getPatients(){
        List<PatienResponseDTO> patien = patienService.getPatiens();
        return ResponseEntity.ok().body(patien);
    }

    @PostMapping
    @Operation(summary = "Create a new patient", description = "Create a new patient with the provided details")
    public ResponseEntity<PatienResponseDTO> createPatient(@Validated({Default.class, UpdatePatientValidationGroup.class} ) @RequestBody PatientRequestDTO patientRequestDTO){
        PatienResponseDTO patienResponseDTO = patienService.createPatien(patientRequestDTO);
        return ResponseEntity.ok().body(patienResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a patient", description = "Update an existing patient with the provided details")
    public ResponseEntity<PatienResponseDTO> updatePatient(@PathVariable UUID id, @Validated(Default.class) @RequestBody PatientRequestDTO patientRequestDTO){
        PatienResponseDTO patienResponseDTO = patienService.updatePatien(id, patientRequestDTO);
        return ResponseEntity.ok().body(patienResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient", description = "Delete an existing patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id ){
        patienService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
