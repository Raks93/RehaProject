package com.project.reha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@Table(name = "EVENT_TABLE")
public class Event extends AbstractPO {

    @Column(name = "NAME")
    private LocalDateTime dateTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DOCTOR")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
