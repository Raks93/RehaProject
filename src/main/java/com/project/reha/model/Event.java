package com.project.reha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "EVENT")
public class Event extends AbstractPO {

    @Column(name = "NAME")
    private LocalDateTime dateTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DOCTOR")
    private String comment;
}
