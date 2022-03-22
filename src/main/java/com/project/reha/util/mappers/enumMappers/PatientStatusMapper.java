package com.project.reha.util.mappers.enumMappers;


import com.project.reha.enums.PatientStatus;
import org.springframework.stereotype.Component;

@Component
public class PatientStatusMapper {

    public static String mapPatientStatusToString(PatientStatus status) {
        if (status == null) return null;
        switch(status) {
            case TREATING: return "Treating";
            case DISCHARGING: return "Discharging";
            default: {
                System.out.println("Логирование");
                return null;

            }

        }
    }

    public static PatientStatus mapStringToPatientStatus(String status) {
        if (status == null) return null;
        switch(status) {
            case "Treating": return PatientStatus.TREATING;
            case "Discharging": return PatientStatus.DISCHARGING;
            default: {
                System.out.println("Логирование");
                return null;
            }

        }
    }
}
