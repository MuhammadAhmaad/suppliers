package com.example.suppliers.services;

import com.example.suppliers.dtos.ClinicDTO;
import com.example.suppliers.entity.Clinic;

public interface ClinicService {
    ClinicDTO addClinic(ClinicDTO clinicDTO);
}
