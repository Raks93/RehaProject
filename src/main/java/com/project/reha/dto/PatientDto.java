package com.project.reha.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientDto {

    private Long id;

    private String name;

    private String diagnosis;

    private String insuranceNumber;

    private String doctor;

    private String status;

    private List<PrescriptionDto> prescriptionDtoList;

    public PatientDto(Long id, String name, String diagnosis, String insuranceNumber, String doctor, String status) {
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.doctor = doctor;
        this.status = status;
    }

    public PatientDto() {

    }
}
