package com.project.reha.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrescriptionDto {

    private Long id;

    private Long times;

    private String period;

    private LocalDate startDate;

    private LocalDate endDate;

    private String nameProcedure;

    private String typeProcedure;

    private String dose;

    private Long patientId;

    private Long procedureId;

    public PrescriptionDto(Long id, Long times, String period, LocalDate startDate, LocalDate endDate,
                           String dose) {
        this.id = id;
        this.times = times;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dose = dose;
    }

    public PrescriptionDto(Long id, Long times, String period, LocalDate startDate, LocalDate endDate, String nameProcedure, String typeProcedure, String dose, Long patientId, Long procedureId) {
        this.id = id;
        this.times = times;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameProcedure = nameProcedure;
        this.typeProcedure = typeProcedure;
        this.dose = dose;
        this.patientId = patientId;
        this.procedureId = procedureId;
    }

    public PrescriptionDto() {
    }


}
