package com.example.suppliers.services;

import com.example.suppliers.constant.SuppliersConstants;
import com.example.suppliers.dtos.ClinicDTO;
import com.example.suppliers.dtos.PatientDTO;
import com.example.suppliers.entity.Clinic;
import com.example.suppliers.entity.Patient;
import com.example.suppliers.exceptions.BusinessException;
import com.example.suppliers.repositories.ClinicRepository;
import com.example.suppliers.utils.SuppliersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;
    @Override
    public ClinicDTO addClinic(ClinicDTO clinicDTO) {
        try {
            Clinic clinic = SuppliersUtil.convertToEntity(clinicDTO, Clinic.class);
            clinic = clinicRepository.save(clinic);
            clinicDTO = SuppliersUtil.convertToDto(clinic, ClinicDTO.class);
            return clinicDTO;
        }catch (Exception e) {
            throw new BusinessException(SuppliersConstants.CLINIC_CREATION_FAILED_CODE,SuppliersConstants.CLINIC_CREATION_FAILED_MESSAGE);
        }
    }
}
