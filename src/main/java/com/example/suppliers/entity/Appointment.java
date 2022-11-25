package com.example.suppliers.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
@SequenceGenerator(name = "APPOINTMENT_SEQ", sequenceName = "APPOINTMENT_SEQ", allocationSize = 1)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT_SEQ")
    private Long id;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "CLINIC_ID", referencedColumnName = "ID")
    private Clinic clinic;

    @ManyToOne(optional = true)
    @JoinColumn(name = "CANCELLATION_REASON_ID", referencedColumnName = "ID")
    private CancellationReason cancellationReason;

    public Appointment() {

    }

    public Appointment(Long id, Date date, Patient patient, Clinic clinic, CancellationReason cancellationReason) {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public CancellationReason getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(CancellationReason cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", patient=" + patient +
                ", clinic=" + clinic +
                ", cancellationReason=" + cancellationReason +
                '}';
    }
}
