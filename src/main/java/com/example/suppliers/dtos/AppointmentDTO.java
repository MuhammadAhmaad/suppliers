package com.example.suppliers.dtos;

import javax.validation.constraints.NotNull;
import java.util.Date;
public class AppointmentDTO {
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private PatientDTO patient;
    @NotNull
    private ClinicDTO clinic;

    private CancellationReasonDTO cancellationReason;

    public AppointmentDTO() {

    }

    public AppointmentDTO(Long id, Date date, PatientDTO patient, ClinicDTO clinic, CancellationReasonDTO cancellationReason) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.clinic = clinic;
        this.cancellationReason = cancellationReason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public ClinicDTO getClinic() {
        return clinic;
    }

    public void setClinic(ClinicDTO clinic) {
        this.clinic = clinic;
    }

    public CancellationReasonDTO getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(CancellationReasonDTO cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
