package com.example.suppliers.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PATIENT")
@SequenceGenerator(name = "PATIENT_SEQ", sequenceName = "PATIENT_SEQ", allocationSize = 1)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT_SEQ")
    private Long id;

    private String name;

    private Date creationDate;


    public Patient(){

    }

    public Patient(Long id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
