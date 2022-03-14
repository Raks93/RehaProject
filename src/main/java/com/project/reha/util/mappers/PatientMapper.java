package com.project.reha.util.mappers;

import com.project.reha.dto.PatientDto;
import com.project.reha.util.mappers.enumMappers.PatientStatusMapper;
import com.project.reha.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public static PatientDto mapPatientToPatientDto (Patient patient) {
        return new PatientDto(
                patient.getId(), patient.getName(), patient.getDiagnosis(),
                patient.getInsuranceNumber(), patient.getDoctor(),
                PatientStatusMapper.mapPatientStatusToString(patient.getStatus()));
    }

    public static Patient mapPatientDtoToPatient (PatientDto patientDto) {
        return new Patient(patientDto.getId(), patientDto.getName(), patientDto.getDiagnosis(),
                    patientDto.getInsuranceNumber(), patientDto.getDoctor(),
                    PatientStatusMapper.mapStringToPatientStatus(patientDto.getStatus()));
    }
}
