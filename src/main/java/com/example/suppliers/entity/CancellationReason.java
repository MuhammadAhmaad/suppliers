package com.example.suppliers.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CANCELLATION_REASON")
public class CancellationReason {

    @Id
    private Long id;

    private String code;

    private String description;

    public CancellationReason(){

    }
    public CancellationReason(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CancellationReason{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
