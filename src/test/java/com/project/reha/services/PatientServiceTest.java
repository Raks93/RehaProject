package com.project.reha.services;

import com.project.reha.dto.PatientDto;
import com.project.reha.enums.PatientStatus;
import com.project.reha.model.Patient;
import com.project.reha.service.PatientService;
import com.project.reha.util.mappers.enumMappers.PatientStatusMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindEmptyPatient() {
        Optional<Patient> optionalPatient = patientService.findPatientByNameAndInsuranceNumber(null, null);

        Assert.assertFalse(optionalPatient.isPresent());
    }

    @Test
    public void testFindPatient() {
        Optional<Patient> expectedPatient = patientService.findFirstParentOrderByName();
        Optional<Patient> actualPatient = Optional.empty();

        if (expectedPatient.isPresent()) {
            actualPatient = patientService.findPatientByNameAndInsuranceNumber(
                    expectedPatient.get().getName(), expectedPatient.get().getInsuranceNumber());
        }
        Assert.assertEquals(expectedPatient, actualPatient);
    }

    @Test
    public void testCreatePatient() {
        PatientDto patientDto = new PatientDto(null,"Vlad", "Pancreatitis",
                "1000000ad", "Popov",
                PatientStatusMapper.mapPatientStatusToString(PatientStatus.TREATING));

        Optional<Patient> optionalPatient = patientService.findPatientByNameAndInsuranceNumber(
                patientDto.getName(), patientDto.getInsuranceNumber());

        if (optionalPatient.isPresent())  {
            patientService.deletePatientByNameAndInsuranceNumber(patientDto.getName(), patientDto.getInsuranceNumber());
        }

        patientService.createPatient(patientDto);
        optionalPatient = patientService.findPatientByNameAndInsuranceNumber(patientDto.getName(), patientDto.getInsuranceNumber());

        Assert.assertTrue(optionalPatient.isPresent());
    }


    @Test
    public void testDeletePatient() {
        PatientDto patientDto = new PatientDto(null,"Vlad", "Pancreatitis",
                "1000000ad", "Popov",
                PatientStatusMapper.mapPatientStatusToString(PatientStatus.TREATING));

        patientService.deletePatientByNameAndInsuranceNumber(patientDto.getName(), patientDto.getInsuranceNumber());

        Optional<Patient> optionalPatient = patientService.findPatientByNameAndInsuranceNumber(
                patientDto.getName(), patientDto.getInsuranceNumber());

        Assert.assertTrue(optionalPatient.isEmpty());
    }
}
