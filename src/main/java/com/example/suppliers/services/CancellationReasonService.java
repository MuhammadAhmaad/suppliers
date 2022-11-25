package com.example.suppliers.services;

import com.example.suppliers.entity.CancellationReason;

public interface CancellationReasonService {
     CancellationReason getByCode(String code);
}
