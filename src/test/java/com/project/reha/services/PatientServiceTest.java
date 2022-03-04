package com.project.reha.services;

import com.project.reha.enums.PatientStatus;
import com.project.reha.model.Patient;
import com.project.reha.service.PatientService;
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
    public void testFindPatient() {
//        Patient patient = new Patient("Vlad", "Pancreatitis", "1000000ad", "Popov", PatientStatus.TREATING);
        Patient patient = new Patient();

        Optional<Patient> optionalPatient = patientService.findPatient(patient);

        Assert.assertFalse(optionalPatient.isPresent());
//        Assert.assertEquals(patient, optionalPatient.get());

    }

    @Test
    public void testCreatePatient() {
        Patient expectedPatient = new Patient("Vlad", "Pancreatitis", "1000000ad", "Popov", PatientStatus.TREATING);

        Optional<Patient> optionalPatient = patientService.findPatient(expectedPatient);

        if (optionalPatient.isEmpty())  {
            patientService.createPatient(expectedPatient);
            optionalPatient = patientService.findPatient(expectedPatient);
        }

        Assert.assertTrue(optionalPatient.isPresent());
        Assert.assertEquals(expectedPatient, optionalPatient.get());
    }
}
