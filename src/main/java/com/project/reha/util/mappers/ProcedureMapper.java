package com.project.reha.util.mappers;

import com.project.reha.dto.ProcedureDto;
import com.project.reha.model.Procedure;
import com.project.reha.util.mappers.enumMappers.ProcedureTypeMapper;
import org.springframework.stereotype.Component;

@Component
public class ProcedureMapper {

    public static ProcedureDto mapProcedureToProcedureDto (Procedure procedure) {
        return new ProcedureDto(
                procedure.getId(), procedure.getName(),
                ProcedureTypeMapper.mapProcedureTypeToString(procedure.getType()));
    }

    public static Procedure mapProcedureDtoToProcedure (ProcedureDto procedureDto) {
        return new Procedure(procedureDto.getId(), procedureDto.getName(),
                ProcedureTypeMapper.mapStringToProcedureType(procedureDto.getType()));
    }
}
