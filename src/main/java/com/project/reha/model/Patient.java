package com.project.reha.model;

import com.project.reha.enums.PatientStatus;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "PATIENT_TABLE")
public class Patient extends AbstractPO {

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "DIAGNOSIS")
    private String diagnosis;

    @NotNull
    @Column(name = "INSURANCE_NUMBER")
    private String insuranceNumber;

    @NotNull
    @Column(name = "DOCTOR")
    private String doctor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private PatientStatus status;

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
