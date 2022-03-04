package com.project.reha.dao;

import com.project.reha.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientDao extends JpaRepository<Patient, Long> {

    Optional<Patient> findPatientByNameAndInsuranceNumber(String name, String insuranceNumber);
}
