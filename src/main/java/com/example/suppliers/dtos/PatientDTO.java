package com.example.suppliers.dtos;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PatientDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Date creationDate;

    public PatientDTO(){

    }

    public PatientDTO(Long id, String name, Date creationDate) {
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
}
