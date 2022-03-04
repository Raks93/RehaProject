package com.project.reha.dao;

import com.project.reha.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionDao extends JpaRepository<Prescription, Long> {
}
