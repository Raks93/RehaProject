package com.project.reha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "PATIENT_TABLE")
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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
        prescription.setPatient(this);
    }

    public void removePrescription(Prescription prescription) {
        this.prescriptions.remove(prescription);
        prescription.setPatient(null);
    }

    public void addEvent(Event event) {
        this.events.add(event);
        event.setPatient(this);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
        event.setPatient(null);
    }


}
