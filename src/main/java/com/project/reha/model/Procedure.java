package com.project.reha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "PROCEDURE_TABLE")
public class Procedure extends AbstractPO {

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;
}