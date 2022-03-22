package com.project.reha.service;

import com.project.reha.dao.ProcedureDao;
import com.project.reha.dto.ProcedureDto;
import com.project.reha.enums.ProcedureType;
import com.project.reha.model.Procedure;
import com.project.reha.util.mappers.ProcedureMapper;
import com.project.reha.util.mappers.enumMappers.ProcedureTypeMapper;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;

import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SessionScoped
@Service
public class ProcedureService {
    private final ProcedureDao procedureDao;



    private ProcedureDto procedureDto = new ProcedureDto();

    public ProcedureService(ProcedureDao procedureDao) {
        this.procedureDao = procedureDao;
    }

    public List<ProcedureDto> getAllProcedures() {
        List<ProcedureDto> procedureDtoList = new ArrayList<>();
        List<Procedure> patients = procedureDao.findAll();
        for (Procedure procedure : patients) {
            procedureDtoList.add(ProcedureMapper.mapProcedureToProcedureDto(procedure));
        }
        return procedureDtoList;
    }

    public ProcedureDto getProcedureDto() {
        return procedureDto;
    }

    //перенести в другой слой
    public String save() {
        Optional<Procedure> optionalProcedure = findByNameAndType(procedureDto.getName(), ProcedureTypeMapper.mapStringToProcedureType(procedureDto.getType()));
        if (optionalProcedure.isPresent()) return "/procedure/addProcedure.xhtml";
        try{
            Procedure procedure = ProcedureMapper.mapProcedureDtoToProcedure(procedureDto);
            procedureDao.save(procedure);
            procedureDto = new ProcedureDto();
        }
        catch (PropertyValueException e) {
            System.out.println("Обработка ошибки и логирование");
            return null;
        }
        return "/procedure/allProcedures.xhtml";
    }

    //перенести в другой слой
    public String addProcedure() {
        if (procedureDto.getName() != null) {
            procedureDto = new ProcedureDto();
        }
        return "/procedure/addProcedure.xhtml";
    }

    public Optional<Procedure> findByNameAndType(String name, ProcedureType type) {
        return procedureDao.findProcedureByNameAndType(name, type);
    }

    public void setProcedureDto(ProcedureDto procedureDto) {
        this.procedureDto = procedureDto;
    }
}
