package com.example.suppliers.repositories;

import com.example.suppliers.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameLike(String name);
}
