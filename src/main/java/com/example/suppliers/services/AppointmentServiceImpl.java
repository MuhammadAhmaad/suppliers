package com.example.suppliers.services;

import com.example.suppliers.constant.SuppliersConstants;
import com.example.suppliers.dtos.AppointmentDTO;
import com.example.suppliers.entity.Appointment;
import com.example.suppliers.entity.CancellationReason;
import com.example.suppliers.exceptions.BusinessException;
import com.example.suppliers.repositories.AppointmentRepository;
import com.example.suppliers.repositories.CancellationReasonRepository;
import com.example.suppliers.utils.SuppliersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private CancellationReasonRepository cancellationReasonRepository;
    @Autowired
    private CancellationReasonService cancellationReasonService;
    @Override
    public List<AppointmentDTO> getTodayAppointments(Long clinicId) {
        Date today = SuppliersUtil.getDateWithoutTime();
        Date todayLastHour = SuppliersUtil.getLastSecondDate();
        List<Appointment> appointmentList =appointmentRepository.findByClinic_IdAndDateBetween(clinicId,today,todayLastHour);
        if(!appointmentList.isEmpty()){
            return appointmentList.stream().map(item -> SuppliersUtil.convertToDto(item,AppointmentDTO.class)).collect(Collectors.toList());
        }else {
            return null;
        }
    }

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) throws ParseException {

        try {
            Appointment appointment = SuppliersUtil.convertToEntity(appointmentDTO, Appointment.class);
            appointment = appointmentRepository.save(appointment);
            appointmentDTO = SuppliersUtil.convertToDto(appointment, AppointmentDTO.class);
            return appointmentDTO;
        }catch (Exception e) {
            throw new BusinessException(SuppliersConstants.APPOINTMENT_CREATION_FAILED_CODE,SuppliersConstants.APPOINTMENT_CREATION_FAILED_MESSAGE);
        }
    }

    @Override
    public AppointmentDTO cancelAppointment(String appointmentId , String cancellationCode) {
        Long appointmentIdLong = Long.parseLong(appointmentId);
        if(appointmentIdLong!=null) {
            Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentIdLong);
            CancellationReason cancellationReason = cancellationReasonRepository.findById(Long.parseLong(cancellationCode)).get();
            Appointment appointment=appointmentOptional.get();
            appointment.setCancellationReason(cancellationReason);
            appointment = appointmentRepository.save(appointment);
           return SuppliersUtil.convertToDto(appointment,AppointmentDTO.class);

        }else {
            throw new BusinessException(SuppliersConstants.APPOINTMENT_NOT_FOUND_CODE,SuppliersConstants.APPOINTMENT_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDate(Date date) {
        Date startDate = SuppliersUtil.getDateWithoutTime(date);
        Date endDate = SuppliersUtil.getLastSecondDate(date);
        return getAppointmentDTOS(startDate, endDate);
    }

    private List<AppointmentDTO> getAppointmentDTOS(Date startDate, Date endDate) {
        List<Appointment> appointmentList =appointmentRepository.findByDateBetween(startDate,endDate);
        if(!appointmentList.isEmpty()){
            return appointmentList.stream().map(item -> SuppliersUtil.convertToDto(item,AppointmentDTO.class)).collect(Collectors.toList());
        }else {
            return null;
        }
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByPatientName(String patientName) {
        List<Appointment> appointmentList = appointmentRepository.findByPatientNameIgnoreCaseContaining(patientName);
        if(!appointmentList.isEmpty()){
            return appointmentList.stream().map(item -> SuppliersUtil.convertToDto(item,AppointmentDTO.class)).collect(Collectors.toList());
        }else {
            return null;
        }
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPatientNameAndDateAndClinic(String patientName, Date date, String clinicId) {
        Date startDate = SuppliersUtil.getDateWithoutTime(date);
        Date endDate = SuppliersUtil.getLastSecondDate(date);
        Long clinicIdLong = Long.parseLong(clinicId);
        List<Appointment> appointmentList = appointmentRepository.findByDateBetweenAndClinicIdAndPatientNameIgnoreCaseContaining(startDate,endDate,clinicIdLong,patientName);
        if(!appointmentList.isEmpty()){
            return appointmentList.stream().map(item -> SuppliersUtil.convertToDto(item,AppointmentDTO.class)).collect(Collectors.toList());
        }else {
            return null;
        }
    }

}
