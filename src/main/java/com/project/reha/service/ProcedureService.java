package com.project.reha.service;

import com.project.reha.dao.ProcedureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcedureService {
    private final ProcedureDao procedureDao;


}
