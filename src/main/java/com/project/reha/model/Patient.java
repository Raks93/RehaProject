package com.project.reha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient extends AbstractPO {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DIAGNOSIS")
    private String diagnosis;

    @Column(name = "INSURANCE_NUMBER")
    private String insuranceNumber;

    @Column(name = "DOCTOR")
    private String doctor;

    @Column(name = "STATUS")
    private String status;
}
