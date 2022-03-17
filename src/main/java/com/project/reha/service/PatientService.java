package com.project.reha.service;

import com.project.reha.dao.PatientDao;
import com.project.reha.dto.PatientDto;
import com.project.reha.util.mappers.PatientMapper;
import com.project.reha.model.Patient;
import lombok.RequiredArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Service
@SessionScope
@RequiredArgsConstructor
public class PatientService {
    private final PatientDao patientDao;

    public void createPatient(PatientDto patientDto) {
        Optional<Patient> optionalPatient = findPatientByNameAndInsuranceNumber(patientDto.getName(), patientDto.getInsuranceNumber());

        if (optionalPatient.isEmpty()) {
            try{
                patientDao.saveAndFlush(PatientMapper.mapPatientDtoToPatient(patientDto));
            }
            catch (PropertyValueException e) {
                System.out.println("Обработка ошибки и логирование");
            }
        }
    }

    public Optional<Patient> findPatientByNameAndInsuranceNumber(String name, String insuranceNumber) {
        return patientDao.findPatientByNameAndInsuranceNumber(name, insuranceNumber);
    }

    public void deletePatientByNameAndInsuranceNumber(String name, String insuranceNumber) {

        Optional<Patient> optionalPatient = patientDao.findPatientByNameAndInsuranceNumber(name, insuranceNumber);

        optionalPatient.ifPresent(patient -> patientDao.deleteById(patient.getId()));
    }

    public Optional<Patient> findFirstParentOrderByName() {
        return patientDao.findFirstByOrderByNameAsc();
    }
}
