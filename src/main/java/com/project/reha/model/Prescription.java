package com.project.reha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PRESCRIPTION_TABLE")
public class Prescription extends AbstractPO {

    @Column(name = "TYPE")
    private String type;

    @Column(name = "TIME_PATTERN")
    private String timePattern;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "DOSE")
    private String dose;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
