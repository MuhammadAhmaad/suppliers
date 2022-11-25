package com.example.suppliers.services;

import com.example.suppliers.dtos.AppointmentDTO;
import com.example.suppliers.entity.Appointment;
import com.example.suppliers.entity.Clinic;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getTodayAppointments(Long clinicId);
    AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) throws ParseException;
    AppointmentDTO cancelAppointment(String appointmentId,String cancellationCode);
    List<AppointmentDTO> getAppointmentsByDate(Date date);
    List<AppointmentDTO> getAppointmentsByPatientName(String patientName);
    List<AppointmentDTO> getAppointmentByPatientNameAndDateAndClinic(String patientName, Date date, String  clinicId);
}
