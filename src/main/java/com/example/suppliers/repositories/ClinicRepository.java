package com.example.suppliers.repositories;

import com.example.suppliers.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
