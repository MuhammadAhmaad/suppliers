package com.example.suppliers.services;

import com.example.suppliers.entity.CancellationReason;
import com.example.suppliers.repositories.CancellationReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellationReasonServiceImpl implements CancellationReasonService {
    @Autowired
    private CancellationReasonRepository cancellationReasonRepository;
    @Override
    public CancellationReason getByCode(String code) {
        return cancellationReasonRepository.findByCode(code);
    }
}
