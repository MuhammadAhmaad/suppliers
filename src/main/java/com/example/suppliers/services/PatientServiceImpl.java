package com.example.suppliers.services;


import com.example.suppliers.constant.SuppliersConstants;
import com.example.suppliers.dtos.AppointmentDTO;
import com.example.suppliers.dtos.PatientDTO;
import com.example.suppliers.entity.Appointment;
import com.example.suppliers.entity.Patient;
import com.example.suppliers.exceptions.BusinessException;
import com.example.suppliers.repositories.PatientRepository;
import com.example.suppliers.utils.SuppliersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> findByName(String name) {
        return patientRepository.findByNameLike(name);
    }

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {
        try {
            Patient patient = SuppliersUtil.convertToEntity(patientDTO, Patient.class);
            patient = patientRepository.save(patient);
            patientDTO = SuppliersUtil.convertToDto(patient, PatientDTO.class);
            return patientDTO;
        }catch (Exception e) {
            throw new BusinessException(SuppliersConstants.PATIENT_CREATION_FAILED_CODE,SuppliersConstants.PATIENT_CREATION_FAILED_MESSAGE);
        }
    }


}
