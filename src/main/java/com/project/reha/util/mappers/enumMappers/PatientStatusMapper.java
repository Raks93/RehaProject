package com.project.reha.util.mappers.enumMappers;


import com.project.reha.enums.PatientStatus;
import org.springframework.stereotype.Component;

@Component
public class PatientStatusMapper {

    public static String mapPatientStatusToString(PatientStatus status) {
        switch(status) {
            case TREATING: return "Treating";
            case DISCHARGING: return "Discharging";
            default: {
                System.out.println("Логирование");
                return null;
//                throw new IllegalArgumentException();
            }

        }
    }

    public static PatientStatus mapStringToPatientStatus(String status) {
        switch(status) {
            case "Treating": return PatientStatus.TREATING;
            case "Discharging": return PatientStatus.DISCHARGING;
            default: {
                System.out.println("Логирование");
                return null;
//                throw new IllegalArgumentException();
            }

        }
    }
}
