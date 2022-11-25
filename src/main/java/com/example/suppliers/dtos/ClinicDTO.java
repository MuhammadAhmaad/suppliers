package com.example.suppliers.dtos;

public class ClinicDTO {
    private Long id;

    private String name;

    public ClinicDTO() {

    }

    public ClinicDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
