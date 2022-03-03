package com.project.reha.dao;

import com.project.reha.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureDao extends JpaRepository<Procedure, Long> {
}
