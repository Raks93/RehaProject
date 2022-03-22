package com.project.reha.dao;

import com.project.reha.enums.ProcedureType;
import com.project.reha.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcedureDao extends JpaRepository<Procedure, Long> {

    Optional<Procedure> findProcedureByNameAndType(String name, ProcedureType type);
}
