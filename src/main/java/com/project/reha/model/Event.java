package com.project.reha.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @NotNull
    @Column(name = "NAME")
    private LocalDateTime dateTime;

    @NotNull
    @Column(name = "STATUS")
    private String status;

    @NotNull
    @Column(name = "DOCTOR")
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
