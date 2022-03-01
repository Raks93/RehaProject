package com.project.reha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDURE")
public class Procedure extends AbstractPO {

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;
}