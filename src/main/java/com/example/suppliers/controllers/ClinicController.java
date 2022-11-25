package com.example.suppliers.controllers;

import com.example.suppliers.dtos.ClinicDTO;
import com.example.suppliers.entity.Clinic;
import com.example.suppliers.model.APIResponseDTO;
import com.example.suppliers.services.ClinicService;
import com.example.suppliers.utils.SuppliersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ResponseEntity<?> createClinic(@RequestBody ClinicDTO clinicDTO) throws Exception {
        ClinicDTO response = clinicService.addClinic(clinicDTO);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }
}