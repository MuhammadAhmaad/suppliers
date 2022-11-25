package com.example.suppliers.services;

import com.example.suppliers.dtos.PatientDTO;
import com.example.suppliers.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAllPatients();
    List<Patient> findByName(String name);
    PatientDTO addPatient(PatientDTO patientDTO);
}
