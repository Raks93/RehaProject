package com.project.reha.util.mappers;

import com.project.reha.dto.PatientDto;
import com.project.reha.model.Patient;
import com.project.reha.util.mappers.enumMappers.PatientStatusMapper;
import com.project.reha.util.mappers.listMappers.ListPrescriptionMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public static PatientDto mapPatientToPatientDto (Patient patient) {
        PatientDto patientDto = new PatientDto(
                patient.getId(), patient.getName(), patient.getDiagnosis(),
                patient.getInsuranceNumber(), patient.getDoctor(),
                PatientStatusMapper.mapPatientStatusToString(patient.getStatus()));
        patientDto.setPrescriptionDtoList(ListPrescriptionMapper.mapPrescriptionListToPrescriptionDtoList(patient.getPrescriptions()));
        return patientDto;
    }

    public static Patient mapPatientDtoToPatient (PatientDto patientDto) {
        Patient patient = new Patient(patientDto.getId(), patientDto.getName(), patientDto.getDiagnosis(),
                patientDto.getInsuranceNumber(), patientDto.getDoctor(),
                PatientStatusMapper.mapStringToPatientStatus(patientDto.getStatus()));
        patient.setPrescriptions(ListPrescriptionMapper.mapPrescriptionDtoListToPrescriptionList(patientDto.getPrescriptionDtoList()));
        patient.setId(patientDto.getId());
        return patient;
    }
}
