package com.project.reha.util.mappers.enumMappers;


import com.project.reha.enums.ProcedureType;
import org.springframework.stereotype.Component;

@Component
public class ProcedureTypeMapper {

    public static String mapProcedureTypeToString(ProcedureType type) {
        if (type == null) return null;
        switch(type) {
            case PROCEDURE: return "Procedure";
            case MEDICINE: return "Medicine";
            default: {
                System.out.println("Логирование");
                return null;
            }

        }
    }

    public static ProcedureType mapStringToProcedureType(String type) {
        if (type == null) return null;
        switch(type) {
            case "Procedure": return ProcedureType.PROCEDURE;
            case "Medicine": return ProcedureType.MEDICINE;
            default: {
                System.out.println("Логирование");
                return null;
            }

        }
    }
}
