package com.project.reha.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractPO {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
