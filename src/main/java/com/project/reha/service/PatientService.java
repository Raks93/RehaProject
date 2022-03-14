package com.project.reha.service;

import com.project.reha.dao.PatientDao;
import com.project.reha.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientDao patientDao;

    public void createPatient(Patient patient) {
        Optional<Patient> optionalPatient = findPatient(patient);

        if (optionalPatient.isEmpty()) {
            patientDao.saveAndFlush(patient);
        }
    }

    public Optional<Patient> findPatient(Patient patient) {
        return patientDao.findPatientByNameAndInsuranceNumber(patient.getName(), patient.getInsuranceNumber());
    }
}
