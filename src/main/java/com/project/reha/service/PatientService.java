package com.project.reha.service;

import com.project.reha.dao.PatientDao;
import com.project.reha.dao.ProcedureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientDao patientDao;

}
