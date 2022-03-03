package com.project.reha.service;

import com.project.reha.dao.PrescriptionDao;
import com.project.reha.dao.ProcedureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionDao prescriptionDao;


}
