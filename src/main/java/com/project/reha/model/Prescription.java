package com.project.reha.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRESCRIPTION_TABLE")
public class Prescription extends AbstractPO {

    @NotNull
    @Column(name = "TIME_PATTERN")
    private String timePattern;

    @NotNull
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "DOSE")
    private String dose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="PROCEDURE_ID", referencedColumnName="ID"),
            @JoinColumn(name="PROCEDURE_TYPE", referencedColumnName="TYPE")
    })
    private Procedure procedure;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        this.events.add(event);
        event.setPrescription(this);
    }

    public void removeEvent(Event event) {
        this.events.remove(event);
        event.setPrescription(null);
    }
}
