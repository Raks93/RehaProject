package com.project.reha.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractPO {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
