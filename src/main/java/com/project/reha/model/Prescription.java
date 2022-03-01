package com.project.reha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRESCRIPTION")
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
}
