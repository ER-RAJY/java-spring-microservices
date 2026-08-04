package org.pm.patientservice.controller;

import org.pm.patientservice.dto.PatienResponseDTO;
import org.pm.patientservice.repository.PatienRepository;
import org.pm.patientservice.service.PatienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatienController {
    private final PatienService  patienService;
    public PatienController(PatienService patienService) {
        this.patienService = patienService;
    }

    public ResponseEntity<List<PatienResponseDTO>> getPatients(){
        List<PatienResponseDTO> patien = patienService.getPatiens();
        return ResponseEntity.ok().body(patien);
    }
}
