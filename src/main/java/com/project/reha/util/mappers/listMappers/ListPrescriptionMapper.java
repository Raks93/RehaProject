package com.project.reha.util.mappers.listMappers;

import com.project.reha.dto.PrescriptionDto;
import com.project.reha.model.Prescription;
import com.project.reha.util.mappers.PrescriptionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListPrescriptionMapper {
    public static List<PrescriptionDto> mapPrescriptionListToPrescriptionDtoList (List<Prescription> prescriptionList) {
        if (prescriptionList  == null) return null;
        List<PrescriptionDto> prescriptionDtoList = new ArrayList<>();
        for (Prescription prescription : prescriptionList) {
            prescriptionDtoList.add(PrescriptionMapper.mapPrescriptionToPrescriptionDto(prescription));
        }
        return prescriptionDtoList;
    }

    public static List<Prescription> mapPrescriptionDtoListToPrescriptionList (List<PrescriptionDto> prescriptionDtoList) {
        if (prescriptionDtoList == null) return null;
        List<Prescription> prescriptionList = new ArrayList<>();
        for (PrescriptionDto prescriptionDto : prescriptionDtoList) {
            prescriptionList.add(PrescriptionMapper.mapPrescriptionDtoToPrescription(prescriptionDto));
        }
        return prescriptionList;
    }
}
