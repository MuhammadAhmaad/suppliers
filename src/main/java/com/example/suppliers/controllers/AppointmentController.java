package com.example.suppliers.controllers;

import com.example.suppliers.dtos.AppointmentDTO;
import com.example.suppliers.dtos.PatientDTO;
import com.example.suppliers.entity.Appointment;
import com.example.suppliers.model.APIResponseDTO;
import com.example.suppliers.services.AppointmentService;
import com.example.suppliers.utils.SuppliersUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        AppointmentDTO response = appointmentService.addAppointment(appointmentDTO);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }

    @GetMapping("/byDate")
    public ResponseEntity<?> findAppointmentByDate(@RequestParam("date") String stringDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(stringDate);
        List<AppointmentDTO> response = appointmentService.getAppointmentsByDate(date);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }

    @GetMapping("/todayAppointment")
    public ResponseEntity<?> findAllAppointmentByDate(@RequestParam("clinicId") String clinicId) throws ParseException {
        Long clinicIdLong = Long.parseLong(clinicId);
        List<AppointmentDTO> response = appointmentService.getTodayAppointments(clinicIdLong);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }

    @GetMapping("/patient")
    public ResponseEntity<?> findAllAppointmentByPatinetName(@RequestParam("name") String patientName) throws ParseException {
        List<AppointmentDTO> response = appointmentService.getAppointmentsByPatientName(patientName);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }

    @GetMapping("/searchByClinicAndPatient")
    public ResponseEntity<?> findAllAppointmentByPatinetNameAndClinicId(@RequestParam("clinicId") String clinicId,@RequestParam("name")  String patientName ) throws ParseException {
        List<AppointmentDTO> response = appointmentService.getAppointmentByPatientNameAndDateAndClinic(patientName,new Date(),clinicId);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }

    @GetMapping("/cancel")
    public ResponseEntity<?> cancelAppointment(@RequestParam("appointmentId") String appointmentId,@RequestParam("cancelId")  String cancelCode ) throws ParseException {
        AppointmentDTO response = appointmentService.cancelAppointment(appointmentId,cancelCode);
        APIResponseDTO apiResponse = null;
        apiResponse = SuppliersUtil.prepeareAPIResponse(response);
        return ok(apiResponse);
    }
}
