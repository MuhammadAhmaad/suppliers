package com.example.suppliers.repositories;

import com.example.suppliers.entity.CancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationReasonRepository  extends JpaRepository<CancellationReason, Long> {
    CancellationReason findByCode(String code);
}
