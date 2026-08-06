package org.pm.patientservice.controller;

import jakarta.validation.Valid;
import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.dto.PatientRequestDTO;
import org.pm.patientservice.repository.PatienRepository;
import org.pm.patientservice.service.PatienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatienController {
    private final PatienService  patienService;
    public PatienController(PatienService patienService) {
        this.patienService = patienService;
    }

    @GetMapping
    public ResponseEntity<List<PatienResponseDTO>> getPatients(){
        List<PatienResponseDTO> patien = patienService.getPatiens();
        return ResponseEntity.ok().body(patien);
    }

    @PostMapping
    public ResponseEntity<PatienResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatienResponseDTO patienResponseDTO = patienService.createPatien(patientRequestDTO);
        return ResponseEntity.ok().body(patienResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatienResponseDTO> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatienResponseDTO patienResponseDTO = patienService.updatePatien(id, patientRequestDTO);
        return ResponseEntity.ok().body(patienResponseDTO);
    }
}
