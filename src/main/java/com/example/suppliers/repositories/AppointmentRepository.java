package com.example.suppliers.repositories;

import com.example.suppliers.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDateBetween(Date startDate,Date endDate);
    List<Appointment> findByClinic_IdAndDateBetween(Long id, Date startDate,Date endDate);
    List<Appointment> findByPatientNameIgnoreCaseContaining(String patientName);
    List<Appointment> findByDateBetweenAndClinicIdAndPatientNameIgnoreCaseContaining(Date startDate,Date endDate,Long clinicId,String patientName);
    List<Appointment> findByDateAndClinicId(Date date,Long clinicId);
    List<Appointment> findByPatientIdAndDate(Long patientId,Date date);
}
