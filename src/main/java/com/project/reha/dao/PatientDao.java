package com.project.reha.dao;

import com.project.reha.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient, Long> {
}
