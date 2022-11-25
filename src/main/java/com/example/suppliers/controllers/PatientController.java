package com.example.suppliers.controllers;

import com.example.suppliers.dtos.PatientDTO;
import com.example.suppliers.model.APIResponseDTO;
import com.example.suppliers.services.PatientService;
import com.example.suppliers.utils.SuppliersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) throws Exception {
        PatientDTO response = patientService.addPatient(patientDTO);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }
}
