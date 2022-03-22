package com.project.reha.service;

import com.project.reha.dao.PrescriptionDao;
import com.project.reha.dao.ProcedureDao;
import com.project.reha.dto.PatientDto;
import com.project.reha.dto.PrescriptionDto;
import com.project.reha.dto.ProcedureDto;
import com.project.reha.enums.ProcedureType;
import com.project.reha.model.Patient;
import com.project.reha.model.Prescription;
import com.project.reha.model.Procedure;
import com.project.reha.util.mappers.PatientMapper;
import com.project.reha.util.mappers.PrescriptionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.SessionScoped;

@SessionScoped
@Service
public class PrescriptionService {
    private final PrescriptionDao prescriptionDao;

    private final ProcedureDao procedureDao;

    private PrescriptionDto prescriptionDto = new PrescriptionDto();

    private PatientDto patientDto = new PatientDto();

    private ProcedureDto procedureDto = new ProcedureDto();

    public PrescriptionService(PrescriptionDao prescriptionDao, ProcedureDao procedureDao) {
        this.prescriptionDao = prescriptionDao;
        this.procedureDao = procedureDao;
    }

    public String addPrescription(PatientDto patientDto) {
        this.patientDto = patientDto;
        return "/prescription/addPrescription.xhtml";
    }

    public String getAllPrescription(PatientDto patientDto) {
        this.patientDto = patientDto;
        return "/prescription/allPrescriptions.xhtml";
    }

    public PrescriptionDto getPrescriptionDto() {
        return prescriptionDto;
    }

    @Transactional
    public String savePrescription() {
        Patient patient = PatientMapper.mapPatientDtoToPatient(patientDto);
        Prescription prescription = PrescriptionMapper.mapPrescriptionDtoToPrescription(prescriptionDto);
        Procedure procedure = procedureDao.getById(procedureDto.getId());
        if (!procedure.getType().equals(ProcedureType.MEDICINE)) prescription.setDose(null);
        prescription.setProcedure(procedure);
        procedure.addPrescription(prescription);
        patient.addPrescription(prescription);
        prescriptionDao.save(prescription);

        return getAllPrescription(PatientMapper.mapPatientToPatientDto(patient));
    }

    public PatientDto getPatientDto() {
        return this.patientDto;
    }

    public ProcedureDto getProcedureDto() {
        return procedureDto;
    }

    public void setProcedureDto(ProcedureDto procedureDto) {
        this.procedureDto = procedureDto;
    }

    public void printProcedureDto(String name){
        System.out.println(name);
        System.out.println(procedureDto.getId());
        System.out.println(procedureDto.getName());
        System.out.println(procedureDto.getType());
    }
}
