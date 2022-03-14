package com.project.reha.dto;

import lombok.Getter;

@Getter
public class PatientDto {

    private final Long id;

    private final String name;

    private final String diagnosis;

    private final String insuranceNumber;

    private final String doctor;

    private final String status;

    public PatientDto(Long id, String name, String diagnosis, String insuranceNumber, String doctor, String status) {
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.doctor = doctor;
        this.status = status;
    }
}
