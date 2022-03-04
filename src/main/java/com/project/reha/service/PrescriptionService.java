package com.project.reha.service;

import com.project.reha.dao.PrescriptionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionDao prescriptionDao;


}
