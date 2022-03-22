package com.project.reha.model;

import com.project.reha.enums.ProcedureType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "PROCEDURE_TABLE")
public class Procedure extends AbstractPO implements Serializable {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ProcedureType type;

    @OneToMany(mappedBy = "procedure", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    @OneToMany(mappedBy = "procedure", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptions = new ArrayList<>();


    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
        prescription.setProcedure(this);
    }

    public void removePrescription(Prescription prescription) {
        this.prescriptions.remove(prescription);
        prescription.setProcedure(null);
    }

    public void addEvent(Event event) {
        this.events.add(event);
        event.setProcedure(this);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
        event.setProcedure(null);
    }

    public Procedure(String name, ProcedureType type) {
        this.name = name;
        this.type = type;
    }

    public Procedure(Long id, String name, ProcedureType type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public Procedure() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "name = " + getName() + ", " +
                "type = " + getType() + ")";
    }
}