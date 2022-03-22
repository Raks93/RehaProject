package com.project.reha.model;

import com.project.reha.enums.EventStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@Table(name = "EVENT_TABLE")
public class Event extends AbstractPO {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private EventStatus status;

    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROCEDURE_ID")
    private Procedure procedure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRESCRIPTION_ID")
    private Prescription prescription;
}
