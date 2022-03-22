package com.project.reha.util.mappers;

import com.project.reha.dto.PrescriptionDto;
import com.project.reha.model.Prescription;
import com.project.reha.util.mappers.enumMappers.ProcedureTypeMapper;
import org.springframework.stereotype.Component;


@Component
public class PrescriptionMapper {

    public static PrescriptionDto mapPrescriptionToPrescriptionDto (Prescription prescription) {
        return new PrescriptionDto(prescription.getId(), getTimesFromPattern(prescription.getTimePattern()),
                getPeriodFromPattern(prescription.getTimePattern()), prescription.getStartDate(),
                prescription.getEndDate(), prescription.getProcedure().getName(),
                ProcedureTypeMapper.mapProcedureTypeToString(prescription.getProcedure().getType()),
                prescription.getDose(), prescription.getPatient().getId(),
                prescription.getProcedure().getId());
    }

    public static Prescription mapPrescriptionDtoToPrescription (PrescriptionDto prescriptionDto) {
        return new Prescription(prescriptionDto.getId(),
                getPatternPromTimesAndPeriod(prescriptionDto.getTimes(), prescriptionDto.getPeriod()),
                prescriptionDto.getStartDate(), prescriptionDto.getEndDate(),
                prescriptionDto.getDose());
    }

    private static Long getTimesFromPattern (String pattern) {
        String[] split = pattern.split("-");
        return Long.parseLong(split[0]);
    }

    private static String getPeriodFromPattern (String pattern) {
        String[] split = pattern.split("-");
        return split[1];
    }

    private static String getPatternPromTimesAndPeriod(Long times, String period) {
        return times + "-" + period;
    }
}

