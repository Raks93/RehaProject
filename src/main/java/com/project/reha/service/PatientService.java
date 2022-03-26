package com.project.reha.service;

import com.project.reha.dao.PatientDao;
import com.project.reha.dto.PatientDto;
import com.project.reha.model.Patient;
import com.project.reha.util.mappers.PatientMapper;
import org.hibernate.PropertyValueException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope
public class PatientService {
    private final PatientDao patientDao;

    private PatientDto patientDto = new PatientDto();

    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public void createPatient(PatientDto creatingPatient) {
        Optional<Patient> optionalPatient = findPatientByNameAndInsuranceNumber(creatingPatient.getName(), creatingPatient.getInsuranceNumber());

        if (optionalPatient.isEmpty()) {
            try{
                patientDao.save(PatientMapper.mapPatientDtoToPatient(creatingPatient));
            }
            catch (PropertyValueException e) {
                System.out.println("Обработка ошибки и логирование");
            }
        }
    }

    public String save() {
        try{
            patientDao.save(PatientMapper.mapPatientDtoToPatient(patientDto));
            patientDto = new PatientDto();
        }
        catch (PropertyValueException e) {
            System.out.println("Обработка ошибки и логирование");
            return null;
        }
        return "/patient/allPatients.xhtml";
    }

    @Transactional
    public String find(String name, String insuranceNumber) {
        Optional<Patient> optionalPatient = findPatientByNameAndInsuranceNumber(name, insuranceNumber);
        if (optionalPatient.isEmpty()) return null;
        patientDto = PatientMapper.mapPatientToPatientDto(optionalPatient.get());
        return "/patient/patient.xhtml";
    }

    public String addPatient() {
        if (patientDto.getName() != null) {
            patientDto = new PatientDto();
        }
        return "/patient/addPatient.xhtml";
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

    @Transactional
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patientDtoList = new ArrayList<>();
        List<Patient> patients = patientDao.findAll();
        for (Patient patient : patients) {
            patientDtoList.add(PatientMapper.mapPatientToPatientDto(patient));
        }
        return patientDtoList;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }
}
